package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;

public class WingParticleCosmetic extends Cosmetic {

    private final HParticle particle;

    public WingParticleCosmetic(int id, String name, Rarity rarity, ItemStack inventoryItem, HParticle particle) {
        super(ClassicWingParticleHandler.class, id, name, Category.PARTICLE, rarity, 2, inventoryItem);
        this.particle = particle;
    }

    public HParticle getParticle() {
        return particle;
    }

}
