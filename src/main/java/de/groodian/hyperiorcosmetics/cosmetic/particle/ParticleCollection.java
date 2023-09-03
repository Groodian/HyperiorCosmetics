package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticCollection;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ParticleCollection extends CosmeticCollection {

    public ParticleCollection() {
        super("Partikel", Category.PARTICLE);
    }

    @Override
    protected List<Cosmetic> registerValues() {
        return Arrays.asList(
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        201,
                        "Wasser Spur",
                        Rarity.UNCOMMON,
                        new ItemBuilder(Material.WATER_BUCKET).build(),
                        new HParticle(Particle.DRIP_WATER)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        202,
                        "Grüne Spur",
                        Rarity.UNCOMMON,
                        new ItemBuilder(Material.EMERALD).build(),
                        new HParticle(Particle.VILLAGER_HAPPY)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        203,
                        "Feuer Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.FIRE_CHARGE).build(),
                        new HParticle(Particle.FLAME, 0, null)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        204,
                        "Herz Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.RED_TULIP).build(),
                        new HParticle(Particle.HEART)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        205,
                        "Musik Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.JUKEBOX).build(),
                        new HParticle(Particle.NOTE)
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
                        PortalParticleHandler.class,
                        207,
                        "EnderAura",
                        Category.PARTICLE,
                        Rarity.EPIC,
                        5,
                        new ItemBuilder(Material.ENDER_EYE).build()
                ),
                new DefaultCosmetic(
                        RingParticleHandler.class,
                        208,
                        "Feuer Ring",
                        Category.PARTICLE,
                        Rarity.EPIC,
                        1,
                        new ItemBuilder(Material.BLAZE_POWDER).build()
                ),
                new WingParticleCosmetic(
                        209,
                        "Weiße Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.FEATHER).build(),
                        new HParticle(Particle.REDSTONE, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 255), 1.0f))
                ),
                new WingParticleCosmetic(
                        210,
                        "Rote Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.RED_DYE).build(),
                        new HParticle(Particle.REDSTONE, 1, new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1.0f))
                ),
                new WingParticleCosmetic(
                        211,
                        "Grüne Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.LIME_DYE).build(),
                        new HParticle(Particle.REDSTONE, 1, new Particle.DustOptions(Color.fromRGB(127, 255, 0), 1.0f))
                ),
                new WingParticleCosmetic(
                        212,
                        "Orange Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.ORANGE_DYE).build(),
                        new HParticle(Particle.REDSTONE, 1, new Particle.DustOptions(Color.fromRGB(255, 165, 0), 1.0f))
                ),
                new DefaultCosmetic(
                        RainbowWingParticleHandler.class,
                        213,
                        "Regenbogen Flügel",
                        Category.PARTICLE,
                        Rarity.MYSTIC,
                        2,
                        new ItemBuilder(Material.CYAN_DYE).build()
                )
        );
    }

}
