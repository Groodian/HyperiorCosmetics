package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickData {

    private CosmeticPlayer cosmeticPlayer;
    private Inventory inventory;
    private InventoryAction inventoryAction;
    private ItemStack itemStack;
    private int slot;

    public ClickData(CosmeticPlayer cosmeticPlayer, Inventory inventory, InventoryAction inventoryAction, ItemStack itemStack, int slot) {
        this.cosmeticPlayer = cosmeticPlayer;
        this.inventory = inventory;
        this.inventoryAction = inventoryAction;
        this.itemStack = itemStack;
        this.slot = slot;
    }

    public CosmeticPlayer getCosmeticPlayer() {
        return cosmeticPlayer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public InventoryAction getInventoryAction() {
        return inventoryAction;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

}
