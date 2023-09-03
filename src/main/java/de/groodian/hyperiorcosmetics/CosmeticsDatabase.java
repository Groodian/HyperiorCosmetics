package de.groodian.hyperiorcosmetics;

import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.util.DatabaseConnection;
import de.groodian.hyperiorcore.util.DatabaseTransaction;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;

public class CosmeticsDatabase {

    private final HyperiorCosmetic hyperiorCosmetic;

    public CosmeticsDatabase(HyperiorCosmetic hyperiorCosmetic) {
        this.hyperiorCosmetic = hyperiorCosmetic;
    }

    /**
     * This method should be executed async
     */
    public CosmeticPlayer loadPlayer(UUID uuid) {
        CosmeticPlayer player = null;

        DatabaseConnection databaseConnection = HyperiorCore.getPaper().getDatabaseManager().getConnection();

        try {
            PreparedStatement ps1 = databaseConnection.getPreparedStatement(
                    "SELECT id, unlocked_at, duplicates FROM hyperior_mc.cosmetics_items WHERE uuid = ?");
            ps1.setObject(1, uuid);
            ResultSet rs1 = ps1.executeQuery();

            List<CosmeticInDatabase> ownedCosmetics = new ArrayList<>();
            while (rs1.next()) {
                ownedCosmetics.add(new CosmeticInDatabase(
                        rs1.getInt("id"),
                        rs1.getObject("unlocked_at", OffsetDateTime.class),
                        rs1.getInt("duplicates")
                ));
            }

            PreparedStatement ps2 = databaseConnection.getPreparedStatement(
                    "SELECT particle, block, helmet, chest_plate, pants, shoes, gadget FROM hyperior_mc.cosmetics WHERE uuid = ?");
            ps2.setObject(1, uuid);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                List<Cosmetic> cosmeticsToActivate = new ArrayList<>();

                for (Category category : Category.values()) {
                    int id = rs2.getInt(category.toString().toLowerCase());
                    if (id > 0) {
                        Cosmetic cosmetic = Cosmetic.getCosmeticsById(id);
                        if (cosmetic != null) {
                            cosmeticsToActivate.add(cosmetic);
                        }
                    }
                }

                player = new CosmeticPlayer(hyperiorCosmetic, uuid, true, cosmeticsToActivate, ownedCosmetics);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseConnection.finish();

        if (player == null) {
            player = new CosmeticPlayer(hyperiorCosmetic, uuid, false, new ArrayList<>(), new ArrayList<>());
        }

        return player;
    }

    public void activate(CosmeticPlayer player, Cosmetic cosmetic) {
        setActivatedCosmetic(player, cosmetic.getCategory(), cosmetic.getId());
    }

    public void deactivate(CosmeticPlayer player, Category category) {
        setActivatedCosmetic(player, category, -1);
    }

    private void setActivatedCosmetic(CosmeticPlayer player, Category category, int cosmeticId) {
        Bukkit.getScheduler().runTaskAsynchronously(hyperiorCosmetic, () -> {

            DatabaseConnection databaseConnection = HyperiorCore.getPaper().getDatabaseManager().getConnection();

            try {

                PreparedStatement ps;
                if (player.isInDatabase()) {
                    ps = databaseConnection.getPreparedStatement(
                            "UPDATE hyperior_mc.cosmetics SET " + category.toString().toLowerCase() + " = ? WHERE uuid = ?");
                    ps.setInt(1, cosmeticId);
                    ps.setObject(2, player.getUuid());
                } else {
                    ps = databaseConnection.getPreparedStatement(
                            "INSERT INTO hyperior_mc.cosmetics (uuid, " + category.toString().toLowerCase() +
                            ") VALUES (?, ?) ON CONFLICT (uuid) DO NOTHING");
                    ps.setObject(1, player.getUuid());
                    ps.setInt(2, cosmeticId);
                }
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            databaseConnection.finish();

        });
    }

    public static class Add extends DatabaseTransaction {

        private final CosmeticPlayer cosmeticPlayer;
        private final CosmeticInDatabase cosmeticInDatabase;

        public Add(CosmeticPlayer cosmeticPlayer, CosmeticInDatabase cosmeticInDatabase) {
            this.cosmeticPlayer = cosmeticPlayer;
            this.cosmeticInDatabase = cosmeticInDatabase;
        }

        @Override
        public void runOnSuccess() {
            cosmeticPlayer.addCosmetic(cosmeticInDatabase);
        }

        @Override
        public boolean run(DatabaseConnection databaseConnection) {
            try {
                if (cosmeticPlayer.isOwningCosmetic(cosmeticInDatabase.getId())) {
                    PreparedStatement ps = databaseConnection.getPreparedStatement(
                            "UPDATE hyperior_mc.cosmetics_items SET duplicates = duplicates + 1 WHERE uuid = ? AND id = ?");

                    ps.setObject(1, cosmeticPlayer.getUuid());
                    ps.setInt(2, cosmeticInDatabase.getId());

                    if (ps.executeUpdate() == 1) {
                        return true;
                    }

                } else {
                    PreparedStatement ps = databaseConnection.getPreparedStatement(
                            "INSERT INTO hyperior_mc.cosmetics_items (uuid, id, unlocked_at, duplicates) VALUES (?, ?, ?, ?) ON CONFLICT (uuid, id) DO NOTHING");

                    ps.setObject(1, cosmeticPlayer.getUuid());
                    ps.setInt(2, cosmeticInDatabase.getId());
                    ps.setObject(3, cosmeticInDatabase.getUnlockedAt());
                    ps.setInt(4, cosmeticInDatabase.getDuplicates());

                    if (ps.executeUpdate() == 1) {
                        return true;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

    }

}
