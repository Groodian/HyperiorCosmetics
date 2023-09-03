package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ClassicBlockCosmetic extends Cosmetic {

    private final boolean onGround;
    private final Material material;

    public ClassicBlockCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem,
                                boolean onGround, Material material) {
        super(clazz, id, name, Category.BLOCK, rarity, 4, inventoryItem);
        this.onGround = onGround;
        this.material = material;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public Material getMaterial() {
        return material;
    }

}
