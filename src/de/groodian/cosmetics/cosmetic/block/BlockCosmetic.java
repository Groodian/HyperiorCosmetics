package de.groodian.cosmetics.cosmetic.block;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BlockCosmetic extends Cosmetic {

    private boolean onGround;
    private Material material;
    private byte subId;

    public BlockCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem, boolean onGround, Material material, byte subId) {
        super(clazz, id, name, Category.BLOCK, rarity, inventoryItem);
        this.onGround = onGround;
        this.material = material;
        this.subId = subId;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public Material getMaterial() {
        return material;
    }

    public byte getSubId() {
        return subId;
    }

}
