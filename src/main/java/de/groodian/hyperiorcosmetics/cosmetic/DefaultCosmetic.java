package de.groodian.hyperiorcosmetics.cosmetic;

import org.bukkit.inventory.ItemStack;

public class DefaultCosmetic extends Cosmetic {

    public DefaultCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Category category, Rarity rarity, int updateRate,
                           ItemStack inventoryItem) {
        super(clazz, id, name, category, rarity, updateRate, inventoryItem);
    }

}
