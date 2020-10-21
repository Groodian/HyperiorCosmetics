package de.groodian.cosmetics;

import com.google.gson.JsonObject;
import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.util.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CosmeticMySQL {

    private static final MySQL cosmeticMySQL = HyperiorCore.getMySQLManager().getCosmeticMySQL();
    private static HyperiorCosmetic hyperiorCosmetic;

    /**
     * This method can be executed sync
     */
    public static void init(HyperiorCosmetic hyperiorCosmetic) {
        CosmeticMySQL.hyperiorCosmetic = hyperiorCosmetic;
    }

    /**
     * This method can be executed sync
     */
    public static int[] getCosmeticIds(UUID uuid) {
        try {
            PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("SELECT cosmetics FROM cosmetic WHERE UUID = ?");
            ps.setString(1, uuid.toString().replaceAll("-", ""));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String cosmeticsString = rs.getString("cosmetics");
                if (cosmeticsString == null) {
                    return null;
                }

                JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(cosmeticsString);
                JSONArray jsonCosmetics = (JSONArray) JSONValue.parseWithException(jsonObject.get("cosmetics").toString());

                int[] cosmetics = new int[jsonCosmetics.size()];
                for (int i = 0; i < jsonCosmetics.size(); i++) {
                    cosmetics[i] = (int) jsonCosmetics.get(i);
                }

                return cosmetics;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method can be executed sync
     */
    public static int getActivatedCosmetic(UUID uuid, Category category) {
        try {
            PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("SELECT " + category + " FROM cosmetic WHERE UUID = ?");
            ps.setString(1, uuid.toString().replaceAll("-", ""));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(category.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This method can be executed sync
     */
    public static void add(final Player player, final Cosmetic cosmetic) {
        Bukkit.getScheduler().runTaskAsynchronously(hyperiorCosmetic, () -> {
            int[] cosmeticIds = getCosmeticIds(player.getUniqueId());

            JSONArray jsonArray = new JSONArray();
            if (cosmeticIds != null) {
                for (int cosmeticId : cosmeticIds) {
                    jsonArray.add(cosmeticId);
                }
            }
            jsonArray.add(cosmetic.getId());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("cosmetics", jsonArray.toString());

            String cosmetics = jsonObject.toString();

            if (isUserExists(player)) {
                try {
                    PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("UPDATE cosmetic SET cosmetics = ?, playername = ? WHERE UUID = ?");
                    ps.setString(1, cosmetics);
                    ps.setString(2, player.getPlayer().getName());
                    ps.setString(3, player.getPlayer().getUniqueId().toString().replaceAll("-", ""));
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("INSERT INTO cosmetic (UUID,playername,cosmetics) VALUES (?,?,?)");
                    ps.setString(1, player.getPlayer().getUniqueId().toString().replaceAll("-", ""));
                    ps.setString(2, player.getPlayer().getName());
                    ps.setString(3, cosmetics);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * This method can be executed sync
     */
    public static void activate(Player player, Cosmetic cosmetic) {
        setActivatedCosmetic(player, cosmetic.getCategory(), cosmetic.getId());
    }

    /**
     * This method can be executed sync
     */
    public static void deactivate(Player player, Category category) {
        setActivatedCosmetic(player, category, -1);
    }

    private static void setActivatedCosmetic(final Player player, final Category category, final int cosmeticId) {
        Bukkit.getScheduler().runTaskAsynchronously(hyperiorCosmetic, () -> {
            if (isUserExists(player)) {
                try {
                    PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("UPDATE cosmetic SET " + category + " = ?, playername = ? WHERE UUID = ?");
                    ps.setInt(1, cosmeticId);
                    ps.setString(2, player.getPlayer().getName());
                    ps.setString(3, player.getPlayer().getUniqueId().toString().replaceAll("-", ""));
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("INSERT INTO cosmetic (UUID,playername," + category + ") VALUES (?,?,?)");
                    ps.setString(1, player.getPlayer().getUniqueId().toString().replaceAll("-", ""));
                    ps.setString(2, player.getPlayer().getName());
                    ps.setInt(3, cosmeticId);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static boolean isUserExists(Player player) {
        try {
            PreparedStatement ps = cosmeticMySQL.getConnection().prepareStatement("SELECT cosmetics FROM cosmetic WHERE UUID = ?");
            ps.setString(1, player.getPlayer().getUniqueId().toString().replaceAll("-", ""));
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
