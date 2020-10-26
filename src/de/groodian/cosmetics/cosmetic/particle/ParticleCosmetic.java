package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.Rarity;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.inventory.ItemStack;

public class ParticleCosmetic extends Cosmetic {

    private EnumParticle particleType;

    public ParticleCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem, EnumParticle particleType) {
        super(clazz, id, name, Category.PARTICLE, rarity, 3, inventoryItem);
        this.particleType = particleType;
    }

    public EnumParticle getParticleType() {
        return particleType;
    }

}
