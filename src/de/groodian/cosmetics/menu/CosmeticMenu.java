package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

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

    protected ItemStack getEditedItem(Cosmetic cosmetic) {
        ItemStack itemStack = cosmetic.getInventoryItem().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(cosmetic.getRarity().getColor() + cosmetic.getName());
        itemMeta.setLore(Arrays.asList(
                " ",
                "§7Seltenheit: " + cosmetic.getRarity().getColor() + cosmetic.getRarity().getName(),
                "§7Kategorie: " + cosmetic.getCategory().getName(),
                "§7Preis: §e" + cosmetic.getPrice() + " Coins"
        ));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
