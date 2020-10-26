package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.Particle;
import org.bukkit.inventory.ItemStack;

public class ClassicParticleCosmetic extends Cosmetic {

    private Particle particle;

    public ClassicParticleCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem, Particle particle) {
        super(clazz, id, name, Category.PARTICLE, rarity, 3, inventoryItem);
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

}
