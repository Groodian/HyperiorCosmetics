package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;

public class ClassicSuitCosmetic extends Cosmetic {

    private ItemStack equipItem;

    public ClassicSuitCosmetic(int id, String name, Category category, Rarity rarity, ItemStack inventoryItem, ItemStack equipItem) {
        super(ClassicSuitHandler.class, id, name, category, rarity, inventoryItem);
        this.equipItem = equipItem;
    }

    public ItemStack getEquipItem() {
        return equipItem;
    }

}
