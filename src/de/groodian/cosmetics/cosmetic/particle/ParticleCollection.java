package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.ItemBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class ParticleCollection extends CosmeticCollection {

    public ParticleCollection() {
        super("Partikel", Category.PARTICLE);
    }

    @Override
    protected List<Cosmetic> registerValues() {
        return Arrays.asList(
                new ParticleCosmetic(
                        ParticleHandler.class,
                        201,
                        "Wasser Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.WATER_BUCKET).build(),
                        EnumParticle.DRIP_WATER
                ),
                new ParticleCosmetic(
                        ParticleHandler.class,
                        202,
                        "Grüne Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.EMERALD).build(),
                        EnumParticle.VILLAGER_HAPPY
                ),
                new ParticleCosmetic(
                        ParticleHandler.class,
                        203,
                        "Feuer Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.FIREBALL).build(),
                        EnumParticle.FLAME
                ),
                new ParticleCosmetic(
                        ParticleHandler.class,
                        204,
                        "Herz Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.RED_ROSE).build(),
                        EnumParticle.HEART
                ),
                new ParticleCosmetic(
                        ParticleHandler.class,
                        205,
                        "Musik Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.JUKEBOX).build(),
                        EnumParticle.NOTE
                ),
                new DefaultCosmetic(
                        DustParticleHandler.class,
                        206,
                        "Regenbogen Spur",
                        Category.PARTICLE,
                        Rarity.EPIC,
                        1,
                        new ItemBuilder(Material.REDSTONE).build()
                ),
                new DefaultCosmetic(
                        WingParticleHandler.class,
                        207,
                        "Regenbogen Flügel",
                        Category.PARTICLE,
                        Rarity.LEGENDARY,
                        2,
                        new ItemBuilder(Material.FEATHER).build()
                )
        );
    }

}
