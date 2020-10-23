package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class SuitCollection {

    private List<Suit> suits;

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
                                new ItemBuilder(Material.LEATHER_HELMET).setColorAndBuild(0, 0, 0),
                                new ItemBuilder(Material.LEATHER_HELMET).setColorAndBuild(0, 0, 0)
                        ),
                        new ClassicSuitCosmetic(
                                14,
                                "Schwarze Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setColorAndBuild(0, 0, 0),
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setColorAndBuild(0, 0, 0)
                        ),
                        new ClassicSuitCosmetic(
                                15,
                                "Schwarze Hose",
                                Category.PANTS,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setColorAndBuild(0, 0, 0),
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setColorAndBuild(0, 0, 0)
                        ),
                        new ClassicSuitCosmetic(
                                16,
                                "Schwarze Schuhe",
                                Category.SHOES,
                                Rarity.COMMON,
                                new ItemBuilder(Material.LEATHER_BOOTS).setColorAndBuild(0, 0, 0),
                                new ItemBuilder(Material.LEATHER_BOOTS).setColorAndBuild(0, 0, 0)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                17,
                                "Goldhelm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_HELMET),
                                new ItemStack(Material.GOLD_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                18,
                                "Goldbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_CHESTPLATE),
                                new ItemStack(Material.GOLD_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                19,
                                "Goldhose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_LEGGINGS),
                                new ItemStack(Material.GOLD_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                20,
                                "Goldschuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_BOOTS),
                                new ItemStack(Material.GOLD_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                21,
                                "Diamanthelm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_HELMET),
                                new ItemStack(Material.DIAMOND_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                22,
                                "Diamantbrustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_CHESTPLATE),
                                new ItemStack(Material.DIAMOND_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                23,
                                "Diamanthose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_LEGGINGS),
                                new ItemStack(Material.DIAMOND_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                24,
                                "Diamantschuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_BOOTS),
                                new ItemStack(Material.DIAMOND_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                25,
                                "Astronaut Helm",
                                Category.HELMET,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.STAINED_GLASS, (short) 7).build(),
                                new ItemBuilder(Material.STAINED_GLASS, (short) 7).build()
                        ),
                        new ClassicSuitCosmetic(
                                26,
                                "Astronaut Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setColorAndBuild(255, 255, 255),
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setColorAndBuild(255, 255, 255)
                        ),
                        new ClassicSuitCosmetic(
                                27,
                                "Astronaut Hose",
                                Category.PANTS,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setColorAndBuild(255, 255, 255),
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setColorAndBuild(255, 255, 255)
                        ),
                        new ClassicSuitCosmetic(
                                28,
                                "Astronaut Schuhe",
                                Category.SHOES,
                                Rarity.UNCOMMON,
                                new ItemBuilder(Material.LEATHER_BOOTS).setColorAndBuild(255, 255, 255),
                                new ItemBuilder(Material.LEATHER_BOOTS).setColorAndBuild(255, 255, 255)
                        )
                ),
                new Suit(
                        new AdvancedSuitCosmetic(
                                DiscoSuitHandler.class,
                                29,
                                "Disco Helm",
                                Category.HELMET,
                                Rarity.LEGENDARY,
                                new ItemBuilder(Material.LEATHER_HELMET).setColorAndBuild(148, 0, 211)
                        ),
                        new AdvancedSuitCosmetic(
                                DiscoSuitHandler.class,
                                30,
                                "Disco Brustplatte",
                                Category.CHEST_PLATE,
                                Rarity.LEGENDARY,
                                new ItemBuilder(Material.LEATHER_CHESTPLATE).setColorAndBuild(148, 0, 211)
                        ),
                        new AdvancedSuitCosmetic(
                                DiscoSuitHandler.class,
                                31,
                                "Disco Hose",
                                Category.PANTS,
                                Rarity.LEGENDARY,
                                new ItemBuilder(Material.LEATHER_LEGGINGS).setColorAndBuild(148, 0, 211)
                        ),
                        new AdvancedSuitCosmetic(
                                DiscoSuitHandler.class,
                                32,
                                "Disco Schuhe",
                                Category.SHOES,
                                Rarity.LEGENDARY,
                                new ItemBuilder(Material.LEATHER_BOOTS).setColorAndBuild(148, 0, 211)
                        )
                )
        );
    }
}
