package de.groodian.cosmetics.suit;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class SuitCollection {

    private List<Suit> suits;

    public List<Suit> values() {
        if (suits == null) {
            suits = registerSuits();
        }
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
                )
        );
    }
}
