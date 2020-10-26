package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.Particle;
import org.bukkit.inventory.ItemStack;

public class WingParticleCosmetic extends Cosmetic {

    private Particle particle;

    public WingParticleCosmetic(int id, String name, Rarity rarity, ItemStack inventoryItem, Particle particle) {
        super(ClassicWingParticleHandler.class, id, name, Category.PARTICLE, rarity, 2, inventoryItem);
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

}
