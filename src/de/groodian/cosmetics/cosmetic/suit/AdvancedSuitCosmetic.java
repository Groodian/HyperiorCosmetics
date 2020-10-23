package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;

public class AdvancedSuitCosmetic extends Cosmetic {

    public AdvancedSuitCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Category category, Rarity rarity, ItemStack inventoryItem) {
        super(clazz, id, name, category, rarity, inventoryItem);
    }

}
