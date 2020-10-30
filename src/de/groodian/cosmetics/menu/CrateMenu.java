package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CrateMenu extends Menu {

    private static final int PRICE = 1000;

    private OpeningCrateMenu openingCrateMenu;

    public CrateMenu(HyperiorCosmetic hyperiorCosmetic) {
        super(hyperiorCosmetic, "Kisten Shop", 27);
        openingCrateMenu = new OpeningCrateMenu(hyperiorCosmetic);
    }

    @Override
    protected void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        new BukkitRunnable() {
            @Override
            public void run() {
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE).setName("�a").build(), 0, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE).setName("�a").build(), 8, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE).setName("�a").build(), 18, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE).setName("�a").build(), 26, null);
            }
        }.runTaskLater(hyperiorCosmetic, 3);
        new BukkitRunnable() {
            @Override
            public void run() {
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 1, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 7, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 19, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 25, null);
            }
        }.runTaskLater(hyperiorCosmetic, 6);
        new BukkitRunnable() {
            @Override
            public void run() {
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 2, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 6, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 20, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 24, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 9, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("�a").build(), 17, null);
            }
        }.runTaskLater(hyperiorCosmetic, 9);
        new BukkitRunnable() {
            @Override
            public void run() {
                List<String> loreInfo = new ArrayList<>();
                loreInfo.add(" ");
                for (Rarity rarity : Rarity.values()) {
                    loreInfo.add(rarity.getColor() + rarity.getName() + " �7- " + (rarity.getChance() / 100.0) + "%");
                }
                List<String> loreOpen = new ArrayList<>();
                loreOpen.add(" ");
                MenuRunnable menuRunnable = null;
                int coins = HyperiorCore.getCoinSystem().getCoins(cosmeticPlayer.getUuid());
                if (coins < PRICE) {
                    loreOpen.add("�cDir fehlen �e" + (PRICE - coins) + " Coins �cum");
                    loreOpen.add("�ceine Kiste zu �ffnen.");
                } else {
                    loreOpen.add("�aKlicke um eine Kiste");
                    loreOpen.add("�af�r �e" + PRICE + " Coins �azu �ffnen.");
                    menuRunnable = clickData -> {
                        HyperiorCore.getCoinSystem().removeCoins(cosmeticPlayer.getPlayer(), PRICE, true);
                        new HSound(Sound.LEVEL_UP).playFor(cosmeticPlayer.getPlayer());
                        openingCrateMenu.open(cosmeticPlayer);
                    };
                }
                putItem(inventory, new ItemBuilder(Material.BOOK).setName("�a�lInfos").setLore(loreInfo).build(), 12, null);
                putItem(inventory, new ItemBuilder(Material.ENDER_CHEST).setName("�a�l�ffne Kiste").setLore(loreOpen).build(), 14, menuRunnable);
            }
        }.runTaskLater(hyperiorCosmetic, 12);
        new HSound(Sound.CHEST_OPEN).playFor(cosmeticPlayer.getPlayer());
    }

}
