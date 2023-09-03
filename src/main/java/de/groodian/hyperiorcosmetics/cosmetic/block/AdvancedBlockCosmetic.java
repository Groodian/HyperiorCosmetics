package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AdvancedBlockCosmetic extends Cosmetic {

    private final boolean onGround;
    private final List<Material> materials;

    public AdvancedBlockCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem,
                                 boolean onGround, List<Material> materials) {
        super(clazz, id, name, Category.BLOCK, rarity, 4, inventoryItem);
        this.onGround = onGround;
        this.materials = materials;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public List<Material> getMaterials() {
        return materials;
    }

}
