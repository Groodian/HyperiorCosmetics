package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public abstract class CosmeticMenu extends Menu {

    private static final ItemStack ANIMATION_ITEM = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setName("§a").build();
    private static final ItemStack BACK_TO_MAIN_MENU_ITEM = new ItemBuilder(Material.ARROW).setName("§cZurück").build();

    public CosmeticMenu(HyperiorCosmetic hyperiorCosmetic, String titel) {
        super(hyperiorCosmetic, titel, 54);
    }

    @Override
    protected void putItems(final CosmeticPlayer cosmeticPlayer, final Inventory inventory) {
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
                inventory.setItem(45, BACK_TO_MAIN_MENU_ITEM);
                setCosmetics(cosmeticPlayer, inventory);
            }
        }.runTaskLater(hyperiorCosmetic, 8);
    }

    private void setDelayedSlot(final Inventory inventory, final int slot, final int delay) {
        new BukkitRunnable() {
            public void run() {
                inventory.setItem(slot, ANIMATION_ITEM);
            }
        }.runTaskLater(hyperiorCosmetic, delay);
    }

    protected abstract void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory);

    protected ItemStack getEditedItem(Cosmetic cosmetic) {
        ItemStack itemStack = cosmetic.getInventoryItem().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(cosmetic.getRarity().getColor() + cosmetic.getName());
        itemMeta.setLore(Arrays.asList("test", "test1"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void handleClick(ClickData clickData) {
        if (compareItemNames(BACK_TO_MAIN_MENU_ITEM, clickData.getItemStack())) {
            hyperiorCosmetic.getMainMenu().open(clickData.getCosmeticPlayer());
            return;
        }
        handleCosmeticClick(clickData);
    }

    public abstract void handleCosmeticClick(ClickData clickData);

}
