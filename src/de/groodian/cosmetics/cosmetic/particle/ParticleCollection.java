package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcore.util.Particle;
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
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        201,
                        "Wasser Spur",
                        Rarity.UNCOMMON,
                        new ItemBuilder(Material.WATER_BUCKET).build(),
                        new Particle(EnumParticle.DRIP_WATER)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        202,
                        "Grüne Spur",
                        Rarity.UNCOMMON,
                        new ItemBuilder(Material.EMERALD).build(),
                        new Particle(EnumParticle.VILLAGER_HAPPY)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        203,
                        "Feuer Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.FIREBALL).build(),
                        new Particle(EnumParticle.FLAME)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        204,
                        "Herz Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.RED_ROSE).build(),
                        new Particle(EnumParticle.HEART)
                ),
                new ClassicParticleCosmetic(
                        ClassicParticleHandler.class,
                        205,
                        "Musik Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.JUKEBOX).build(),
                        new Particle(EnumParticle.NOTE)
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
                        new ItemBuilder(Material.EYE_OF_ENDER).build()
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
                        new Particle(EnumParticle.REDSTONE, false, 255, 255, 255, 1, 0, 0)
                ),
                new WingParticleCosmetic(
                        210,
                        "Rote Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.INK_SACK, (short) 1).build(),
                        new Particle(EnumParticle.REDSTONE, false, 255, 0, 0, 1, 0, 0)
                ),
                new WingParticleCosmetic(
                        211,
                        "Grüne Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.INK_SACK, (short) 10).build(),
                        new Particle(EnumParticle.REDSTONE, false, 127, 255, 0, 1, 0, 0)
                ),
                new WingParticleCosmetic(
                        212,
                        "Orange Flügel",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.INK_SACK, (short) 14).build(),
                        new Particle(EnumParticle.REDSTONE, false, 255, 165, 0, 1, 0, 0)
                ),
                new DefaultCosmetic(
                        RainbowWingParticleHandler.class,
                        213,
                        "Regenbogen Flügel",
                        Category.PARTICLE,
                        Rarity.MYSTIC,
                        2,
                        new ItemBuilder(Material.INK_SACK, (short) 13).build()
                )
        );
    }

}
