package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticCollection;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;

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
                        new ItemBuilder(Material.SNOWBALL).build(),
                        new ItemBuilder(Material.COMPARATOR).build()
                ),
                new GadgetCosmetic(
                        FireworkGadgetHandler.class,
                        302,
                        "Feuerwerk",
                        Rarity.MYSTIC,
                        0,
                        30,
                        new ItemBuilder(Material.FIREWORK_ROCKET).build(),
                        new ItemBuilder(Material.FIREWORK_ROCKET).build()
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
