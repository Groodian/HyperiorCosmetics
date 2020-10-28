package de.groodian.cosmetics.cosmetic.gadget;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class GadgetCollection extends CosmeticCollection {

    public GadgetCollection() {
        super("Gadgets", Category.GADGET);
    }

    @Override
    protected List<Cosmetic> registerValues() {
        return Arrays.asList(
                new GadgetCosmetic(
                        SnowCanonHandler.class,
                        301,
                        "Schneekanone",
                        Rarity.EPIC,
                        4,
                        10,
                        new ItemBuilder(Material.SNOW_BALL).build(),
                        new ItemBuilder(Material.REDSTONE_COMPARATOR).build()
                ),
                new GadgetCosmetic(
                        FireworkGadgetHandler.class,
                        302,
                        "Feuerwerk",
                        Rarity.MYSTIC,
                        0,
                        30,
                        new ItemBuilder(Material.FIREWORK).build(),
                        new ItemBuilder(Material.FIREWORK).build()
                ),
                new GadgetCosmetic(
                        FlightStickGadgetHandler.class,
                        303,
                        "Flug Stab",
                        Rarity.BLACK_MARKET,
                        0,
                        10,
                        new ItemBuilder(Material.BLAZE_ROD).build(),
                        new ItemBuilder(Material.BLAZE_ROD).build()
                )
        );
    }

}
