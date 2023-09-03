package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import org.bukkit.inventory.ItemStack;

public class ClassicParticleCosmetic extends Cosmetic {

    private final HParticle particle;

    public ClassicParticleCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, ItemStack inventoryItem,
                                   HParticle particle) {
        super(clazz, id, name, Category.PARTICLE, rarity, 3, inventoryItem);
        this.particle = particle;
    }

    public HParticle getParticle() {
        return particle;
    }

}
