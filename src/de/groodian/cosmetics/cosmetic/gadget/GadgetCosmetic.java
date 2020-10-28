package de.groodian.cosmetics.cosmetic.gadget;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetCosmetic extends Cosmetic {

    private ItemStack gadgetItem;
    private int gadgetUpdateRate;
    private int delay;

    public GadgetCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, int gadgetUpdateRate, int delay, ItemStack inventoryItem, ItemStack gadgetItem) {
        super(clazz, id, name, Category.GADGET, rarity, 1, inventoryItem);
        this.gadgetUpdateRate = gadgetUpdateRate;
        this.gadgetItem = gadgetItem;
        this.delay = delay;

        ItemMeta itemMeta = gadgetItem.getItemMeta();
        itemMeta.setDisplayName(getRarity().getColor() + "§l" + getName() + " §7(Rechtsklick)");
        gadgetItem.setItemMeta(itemMeta);
    }

    public int getGadgetUpdateRate() {
        return gadgetUpdateRate;
    }

    public int getDelay() {
        return delay;
    }

    public ItemStack getGadgetItem() {
        return gadgetItem;
    }

}
