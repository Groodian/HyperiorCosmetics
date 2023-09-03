package de.groodian.hyperiorcosmetics.cosmetic.suit;

import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;

public class ClassicSuitCosmetic extends Cosmetic {

    private final ItemStack equipItem;

    public ClassicSuitCosmetic(int id, String name, Category category, Rarity rarity, ItemStack inventoryItem, ItemStack equipItem) {
        super(ClassicSuitHandler.class, id, name, category, rarity, 0, inventoryItem);
        this.equipItem = equipItem;
    }

    public ItemStack getEquipItem() {
        return equipItem;
    }

}
