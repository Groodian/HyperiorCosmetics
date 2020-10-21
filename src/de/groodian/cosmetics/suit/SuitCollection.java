package de.groodian.cosmetics.suit;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Rarity;
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
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_HELMET),
                                new ItemStack(Material.LEATHER_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                2,
                                "Lederbrustplatte",
                                Category.CHEST_PLATE,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_CHESTPLATE),
                                new ItemStack(Material.LEATHER_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                3,
                                "Lederhose",
                                Category.PANTS,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.LEATHER_LEGGINGS),
                                new ItemStack(Material.LEATHER_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                4,
                                "Lederschuhe",
                                Category.SHOES,
                                1000,
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
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_HELMET),
                                new ItemStack(Material.CHAINMAIL_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                6,
                                "Kettenbrustplatte",
                                Category.CHEST_PLATE,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_CHESTPLATE),
                                new ItemStack(Material.CHAINMAIL_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                7,
                                "Kettenhose",
                                Category.PANTS,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.CHAINMAIL_LEGGINGS),
                                new ItemStack(Material.CHAINMAIL_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                8,
                                "Kettenschuhe",
                                Category.SHOES,
                                1000,
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
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_HELMET),
                                new ItemStack(Material.IRON_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                10,
                                "Eisenbrustplatte",
                                Category.CHEST_PLATE,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_CHESTPLATE),
                                new ItemStack(Material.IRON_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                11,
                                "Eisenhose",
                                Category.PANTS,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_LEGGINGS),
                                new ItemStack(Material.IRON_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                12,
                                "Eisenschuhe",
                                Category.SHOES,
                                1000,
                                Rarity.COMMON,
                                new ItemStack(Material.IRON_BOOTS),
                                new ItemStack(Material.IRON_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                13,
                                "Goldhelm",
                                Category.HELMET,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_HELMET),
                                new ItemStack(Material.GOLD_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                14,
                                "Goldbrustplatte",
                                Category.CHEST_PLATE,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_CHESTPLATE),
                                new ItemStack(Material.GOLD_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                15,
                                "Goldhose",
                                Category.PANTS,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_LEGGINGS),
                                new ItemStack(Material.GOLD_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                16,
                                "Goldschuhe",
                                Category.SHOES,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.GOLD_BOOTS),
                                new ItemStack(Material.GOLD_BOOTS)
                        )
                ),
                new Suit(
                        new ClassicSuitCosmetic(
                                17,
                                "Diamanthelm",
                                Category.HELMET,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_HELMET),
                                new ItemStack(Material.DIAMOND_HELMET)
                        ),
                        new ClassicSuitCosmetic(
                                18,
                                "Diamantbrustplatte",
                                Category.CHEST_PLATE,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_CHESTPLATE),
                                new ItemStack(Material.DIAMOND_CHESTPLATE)
                        ),
                        new ClassicSuitCosmetic(
                                19,
                                "Diamanthose",
                                Category.PANTS,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_LEGGINGS),
                                new ItemStack(Material.DIAMOND_LEGGINGS)
                        ),
                        new ClassicSuitCosmetic(
                                20,
                                "Diamantschuhe",
                                Category.SHOES,
                                2000,
                                Rarity.UNCOMMON,
                                new ItemStack(Material.DIAMOND_BOOTS),
                                new ItemStack(Material.DIAMOND_BOOTS)
                        )
                )
        );
    }
}
