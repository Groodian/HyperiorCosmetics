package de.groodian.cosmetics.suit;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.Rarity;
import org.bukkit.inventory.ItemStack;

public class ClassicSuitCosmetic extends Cosmetic {

    private ItemStack equipItem;

    public ClassicSuitCosmetic(int id, String name, Category category, int price, Rarity rarity, ItemStack inventoryItem, ItemStack equipItem) {
        super(ClassicSuitHandler.class, id, name, category, price, rarity, inventoryItem);
        this.equipItem = equipItem;
    }

    public ItemStack getEquipItem() {
        return equipItem;
    }

}
