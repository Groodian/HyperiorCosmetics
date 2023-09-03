package de.groodian.hyperiorcosmetics.cosmetic.suit;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SuitCollection {

    private final List<Suit> suits;

    public SuitCollection() {
        suits = registerSuits();
    }

    public List<Suit> values() {
        return suits;
    }

    private List<Suit> registerSuits() {
        return Arrays.asList(
                new Suit(
                        new ClassicSuitCosmetic(
                                1,
                                "Lederhelm",
                                Category.HELMET,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_HELMET),
                                new ItemStack(Material.LEATHER_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                2,
                                "Lederbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_CHESTPLATE),
                                new ItemStack(Material.LEATHER_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                3,
                                "Lederhose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_LEGGINGS),
                                new ItemStack(Material.LEATHER_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                4,
                                "Lederschuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_BOOTS),
                                new ItemStack(Material.LEATHER_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                5,
                                "Kettenhelm",
                                Category.HELMET,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_HELMET),
                                new ItemStack(Material.CHAINMAIL_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                6,
                                "Kettenbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_CHESTPLATE),
                                new ItemStack(Material.CHAINMAIL_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                7,
                                "Kettenhose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_LEGGINGS),
                                new ItemStack(Material.CHAINMAIL_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                8,
                                "Kettenschuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_BOOTS),
                                new ItemStack(Material.CHAINMAIL_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                9,
                                "Eisenhelm",
                                Category.HELMET,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_HELMET),
                                new ItemStack(Material.IRON_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                10,
                                "Eisenbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_CHESTPLATE),
                                new ItemStack(Material.IRON_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                11,
                                "Eisenhose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_LEGGINGS),
                                new ItemStack(Material.IRON_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                12,
                                "Eisenschuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_BOOTS),
                                new ItemStack(Material.IRON_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                13,
                                "Schwarzer Helm",
                                Category.HELMET,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(0, 0, 0).build(),
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(0, 0, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                14,
                                "Schwarze Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(0, 0, 0).build(),
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(0, 0, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                15,
                                "Schwarze Hose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(0, 0, 0).build(),
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(0, 0, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                16,
                                "Schwarze Schuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(0, 0, 0).build(),
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(0, 0, 0).build()
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                17,
                                "Grüner Helm",
                                Category.HELMET,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(0, 255, 0).build(),
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(0, 255, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                18,
                                "Grüne Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(0, 255, 0).build(),
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(0, 255, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                19,
                                "Grüne Hose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(0, 255, 0).build(),
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(0, 255, 0).build()
                        ),
                        new ClassicSuitCosmetic(
                                20,
                                "Grüne Schuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(0, 255, 0).build(),
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(0, 255, 0).build()
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                21,
                                "Goldhelm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLDEN_HELMET),
                                new ItemStack(Material.GOLDEN_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                22,
                                "Goldbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLDEN_CHESTPLATE),
                                new ItemStack(Material.GOLDEN_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                23,
                                "Goldhose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLDEN_LEGGINGS),
                                new ItemStack(Material.GOLDEN_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                24,
                                "Goldschuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLDEN_BOOTS),
                                new ItemStack(Material.GOLDEN_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                25,
                                "Diamanthelm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_HELMET),
                                new ItemStack(Material.DIAMOND_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                26,
                                "Diamantbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_CHESTPLATE),
                                new ItemStack(Material.DIAMOND_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                27,
                                "Diamanthose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_LEGGINGS),
                                new ItemStack(Material.DIAMOND_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                28,
                                "Diamantschuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_BOOTS),
                                new ItemStack(Material.DIAMOND_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                29,
                                "Astronaut Helm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.GRAY_STAINED_GLASS).build(),
                                new ItemBuilder(Material.GRAY_STAINED_GLASS).build()
                        ),
                        new ClassicSuitCosmetic(
                                30,
                                "Astronaut Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(255, 255, 255).build(),
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(255, 255, 255).build()
                        ),
                        new ClassicSuitCosmetic(
                                31,
                                "Astronaut Hose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(255, 255, 255).build(),
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(255, 255, 255).build()
                        ),
                        new ClassicSuitCosmetic(
                                32,
                                "Astronaut Schuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(255, 255, 255).build(),
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(255, 255, 255).build()
                        )
                ),
                new Suit(
                        new DefaultCosmetic(
                                DiscoSuitHandler.class,
                                33,
                                "Disco Helm",
                                Category.HELMET,
                                Rarity.EPIC,
                                10,
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(148, 0, 211).build()
                        ),
                        new DefaultCosmetic(
                                DiscoSuitHandler.class,
                                34,
                                "Disco Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.EPIC,
                                10,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(148, 0, 211).build()
                        ),
                        new DefaultCosmetic(
                                DiscoSuitHandler.class,
                                35,
                                "Disco Hose",
                                Category.PANTS,
                                Rarity.EPIC,
                                10,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(148, 0, 211).build()
                        ),
                        new DefaultCosmetic(
                                DiscoSuitHandler.class,
                                36,
                                "Disco Schuhe",
                                Category.SHOES,
                                Rarity.EPIC,
                                10,
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(148, 0, 211).build()
                        )
                ),
                new Suit(
                        new DefaultCosmetic(
                                RainbowSuitHandler.class,
                                37,
                                "Rainbow Helm",
                                Category.HELMET,
                                Rarity.LEGENDARY,
                                3,
                                new ItemBuilder(Material.LEATHER_HELMET).setLeatherColor(52, 171, 235).build()
                        ),
                        new DefaultCosmetic(
                                RainbowSuitHandler.class,
                                38,
                                "Rainbow Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.LEGENDARY,
                                3,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherColor(52, 171, 235).build()
                        ),
                        new DefaultCosmetic(
                                RainbowSuitHandler.class,
                                39,
                                "Rainbow Hose",
                                Category.PANTS,
                                Rarity.LEGENDARY,
                                3,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherColor(52, 171, 235).build()
                        ),
                        new DefaultCosmetic(
                                RainbowSuitHandler.class,
                                40,
                                "Rainbow Schuhe",
                                Category.SHOES,
                                Rarity.LEGENDARY,
                                3,
                                new ItemBuilder(Material.LEATHER_BOOTS).setLeatherColor(52, 171, 235).build()
                        )
                )
        );
    }
}
