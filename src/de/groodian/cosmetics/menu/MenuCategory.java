package de.groodian.cosmetics.menu;

import org.bukkit.inventory.ItemStack;

public class MenuCategory {

    private ItemStack itemStack;
    private int slot;
    private Menu menu;

    MenuCategory(ItemStack itemStack, int slot, Menu menu) {
        this.itemStack = itemStack;
        this.slot = slot;
        this.menu = menu;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

    public Menu getMenu() {
        return menu;
    }

}
