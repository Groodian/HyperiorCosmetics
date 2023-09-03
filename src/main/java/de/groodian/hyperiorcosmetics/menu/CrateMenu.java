package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcore.gui.GUIRunnable;
import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.user.CoinSystem;
import de.groodian.hyperiorcore.user.User;
import de.groodian.hyperiorcore.util.DatabaseTransaction;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.CosmeticInDatabase;
import de.groodian.hyperiorcosmetics.CosmeticsDatabase;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CrateMenu extends GUI {

    private static final int PRICE = 1000;

    private final HyperiorCosmetic hyperiorCosmetic;
    private final CosmeticPlayer cosmeticPlayer;

    public CrateMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticPlayer cosmeticPlayer) {
        super(Component.text("Kisten Shop"), 27);
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.cosmeticPlayer = cosmeticPlayer;
    }

    @Override
    protected void onOpen() {
        ItemStack white = new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(Component.empty()).build();
        ItemStack gray = new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(Component.empty()).build();

        putItemsDelayed(white, new int[]{0, 8, 18, 26}, 3);
        putItemsDelayed(gray, new int[]{1, 7, 19, 25}, 6);
        putItemsDelayed(gray, new int[]{2, 6, 20, 24, 9, 17}, 9);

        new BukkitRunnable() {
            @Override
            public void run() {
                List<Component> loreInfo = new ArrayList<>();
                loreInfo.add(Component.empty());
                for (Rarity rarity : Rarity.values()) {
                    loreInfo.add(Component.text(rarity.getName(), rarity.getColor())
                            .append(Component.text(" - " + (rarity.getChance() / 100.0) + "%", NamedTextColor.GRAY)));
                }
                putItem(new ItemBuilder(Material.BOOK)
                        .setName(Component.text("Info", NamedTextColor.GREEN).decoration(TextDecoration.BOLD, true))
                        .setLore(loreInfo)
                        .build(), 12);

                List<Component> loreOpen = new ArrayList<>();
                loreOpen.add(Component.empty());
                GUIRunnable guiRunnable = null;
                User user = HyperiorCore.getPaper().getUserManager().get(cosmeticPlayer.getUuid());
                if (user == null) {
                    return;
                }
                int coins = user.getCoins();
                if (coins < PRICE) {
                    loreOpen.add(Component.text("Dir fehlen ", NamedTextColor.RED)
                            .append(Component.text((PRICE - coins) + " Coins", NamedTextColor.YELLOW))
                            .append(Component.text(" um", NamedTextColor.RED)));
                    loreOpen.add(Component.text("eine Kiste zu öffnen.", NamedTextColor.RED));
                } else {
                    loreOpen.add(Component.text("Klicke um eine Kiste", NamedTextColor.GREEN));
                    loreOpen.add(Component.text("für ", NamedTextColor.GREEN)
                            .append(Component.text(PRICE + " Coins", NamedTextColor.YELLOW))
                            .append(Component.text(" zu öffnen.", NamedTextColor.GREEN)));

                    guiRunnable = () -> {
                        Cosmetic win = Cosmetic.getRandomCosmetic(new Random());
                        boolean isOwningCosmetic = cosmeticPlayer.isOwningCosmetic(win.getId());

                        List<DatabaseTransaction> transactions = new ArrayList<>();
                        transactions.add(new CoinSystem.Remove(PRICE, player));
                        transactions.add(
                                new CosmeticsDatabase.Add(cosmeticPlayer, new CosmeticInDatabase(win.getId(), OffsetDateTime.now(), 0)));
                        if (cosmeticPlayer.isOwningCosmetic(win.getId())) {
                            transactions.add(new CoinSystem.Add(false, win.getRarity().getSellPrice(), player));
                        }

                        HyperiorCore.getPaper().getDatabaseManager().transaction(transactions,
                                success -> {
                                    if (success) {
                                        hyperiorCosmetic.getCosmeticsGUIManager()
                                                .open(player,
                                                        new OpeningCrateMenu(hyperiorCosmetic, cosmeticPlayer, win, isOwningCosmetic));
                                    }
                                });

                    };
                }

                putItem(new ItemBuilder(Material.ENDER_CHEST)
                        .setName(Component.text("Öffne Kiste", NamedTextColor.GREEN).decoration(TextDecoration.BOLD, true))
                        .setLore(loreOpen)
                        .build(), 14, guiRunnable, Duration.ofSeconds(10));
            }
        }.runTaskLater(hyperiorCosmetic, 12);

        new HSound(Sound.BLOCK_CHEST_OPEN).playFor(cosmeticPlayer.getPlayer());
    }

    @Override
    public void onUpdate() {
    }

}
