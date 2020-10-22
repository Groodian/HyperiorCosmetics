package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public abstract class CosmeticMenu extends Menu {

    private static final ItemStack ANIMATION_ITEM = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("§a").build();
    private static final ItemStack BACK_TO_MAIN_MENU_ITEM = new ItemBuilder(Material.REDSTONE).setName("§cZurück").build();
    private static final ItemBuilder PREVIOUS_PAGE = new ItemBuilder(Material.ARROW).setName("§aVorherige Seite");
    private static final ItemBuilder NEXT_PAGE = new ItemBuilder(Material.ARROW).setName("§aNächste Seite");

    private Category[] deactivateCategories;

    private ItemStack deactivateItem;

    public CosmeticMenu(HyperiorCosmetic hyperiorCosmetic, String name, Category... deactivateCategories) {
        super(hyperiorCosmetic, "Kosmetik > " + name, 54);
        this.deactivateCategories = deactivateCategories;

        deactivateItem = new ItemBuilder(Material.BARRIER).setName("§cDeaktiviere " + name).build();
    }

    protected void putItems(final CosmeticPlayer cosmeticPlayer, final Inventory inventory, final int page) {
        setDelayedSlot(inventory, 36, 2);
        setDelayedSlot(inventory, 37, 3);
        setDelayedSlot(inventory, 38, 4);
        setDelayedSlot(inventory, 39, 5);
        setDelayedSlot(inventory, 40, 6);
        setDelayedSlot(inventory, 41, 7);
        setDelayedSlot(inventory, 42, 8);
        setDelayedSlot(inventory, 43, 9);
        setDelayedSlot(inventory, 44, 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                String previousPage = page - 1 + "";
                MenuRunnable previousRunnable = new MenuRunnable() {
                    @Override
                    public void run(ClickData clickData) {
                        open(cosmeticPlayer, page - 1);
                    }
                };
                if (page - 1 <= 0) {
                    previousPage = "-";
                    previousRunnable = null;
                }
                putItem(inventory, BACK_TO_MAIN_MENU_ITEM, 45, clickData -> hyperiorCosmetic.getMainMenu().open(cosmeticPlayer));
                putItem(inventory, PREVIOUS_PAGE.setLore("§7Seite " + previousPage).build(), 48, previousRunnable);
                putItem(inventory, deactivateItem, 49, clickData -> {
                    for (Category category : deactivateCategories) {
                        clickData.getCosmeticPlayer().disableCosmetic(category);
                    }
                    setCosmetics(cosmeticPlayer, inventory, page);
                });
                putItem(inventory, NEXT_PAGE.setLore("§7Seite " + (page + 1)).build(), 50, clickData -> open(cosmeticPlayer, page + 1));
                setCosmetics(cosmeticPlayer, inventory, page);
            }
        }.runTaskLater(hyperiorCosmetic, 8);

        new HSound(Sound.HORSE_SADDLE).playFor(cosmeticPlayer.getPlayer());
    }

    private void setDelayedSlot(final Inventory inventory, final int slot, final int delay) {
        new BukkitRunnable() {
            public void run() {
                inventory.setItem(slot, ANIMATION_ITEM);
            }
        }.runTaskLater(hyperiorCosmetic, delay);
    }

    protected abstract void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page);

    protected void putCosmetic(final CosmeticPlayer cosmeticPlayer, final Inventory inventory, final Cosmetic cosmetic, final int slot, final int page) {
        ItemStack itemStack = cosmetic.getInventoryItem().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(cosmetic.getRarity().getColor() + "§l" + cosmetic.getName());
        MenuRunnable menuRunnable = null;
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Seltenheit: " + cosmetic.getRarity().getColor() + cosmetic.getRarity().getName());
        lore.add("§7Kategorie: " + cosmetic.getCategory().getName());
        lore.add("§7Preis: §e" + cosmetic.getPrice() + " Coins");
        lore.add(" ");
        if (cosmeticPlayer.isOwningCosmetic(cosmetic)) {
            itemMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 0, true);
            if (cosmeticPlayer.isActiveCosmetic(cosmetic)) {
                lore.add("§cKlicke zum Deaktivieren");
                menuRunnable = clickData -> {
                    cosmeticPlayer.disableCosmetic(cosmetic.getCategory());
                    setCosmetics(cosmeticPlayer, inventory, page);
                };
            } else {
                lore.add("§aKlicke zum Aktivieren");
                menuRunnable = clickData -> {
                    cosmeticPlayer.equip(cosmetic);
                    setCosmetics(cosmeticPlayer, inventory, page);
                };
            }
        } else {
            lore.add("§cDu besitzt diesen Gegenstand noch nicht!");
            if (HyperiorCore.getRanks().has(cosmeticPlayer.getUuid(), "cosmetics.buy")) {
                int coins = HyperiorCore.getCoinSystem().getCoins(cosmeticPlayer.getUuid());
                if (coins < cosmetic.getPrice()) {
                    lore.add("§cDir fehlen §e" + (cosmetic.getPrice() - coins) + " Coins §cum");
                    lore.add("§cden Gegenstand zu Kaufen.");
                } else {
                    lore.add("§aKlicke um den Gegenstand für");
                    lore.add("§e" + cosmetic.getPrice() + " Coins §azu Kaufen.");
                    menuRunnable = clickData -> {
                        HyperiorCore.getCoinSystem().removeCoins(cosmeticPlayer.getPlayer(), cosmetic.getPrice(), true);
                        cosmeticPlayer.addCosmetic(cosmetic);
                        setCosmetics(cosmeticPlayer, inventory, page);
                    };
                }
            } else {
                lore.add("§7Du kannst den Gegenstand");
                lore.add("§7dem §eVIP-Rang §7kaufen.");
            }
        }
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        putItem(inventory, itemStack, slot, menuRunnable);
    }

}
