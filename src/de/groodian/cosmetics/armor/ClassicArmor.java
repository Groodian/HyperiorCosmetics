package de.groodian.cosmetics.armor;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum ClassicArmor {

    LEATHER_HELMET(new ClassicArmorCosmetic(
            1,
            "Lederhelm",
            Category.HELMET,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.LEATHER_HELMET),
            new ItemStack(Material.LEATHER_HELMET)
    )),
    LEATHER_CHEST_PLATE(new ClassicArmorCosmetic(
            2,
            "Lederbrustplatte",
            Category.CHEST_PLATE,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_CHESTPLATE)
    )),
    LEATHER_PANTS(new ClassicArmorCosmetic(
            3,
            "Lederhose",
            Category.PANTS,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.LEATHER_LEGGINGS),
            new ItemStack(Material.LEATHER_LEGGINGS)
    )),
    LEATHER_SHOES(new ClassicArmorCosmetic(
            4,
            "Lederschuhe",
            Category.SHOES,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.LEATHER_BOOTS),
            new ItemStack(Material.LEATHER_BOOTS)
    )),
    CHAIN_HELMET(new ClassicArmorCosmetic(
            5,
            "Kettenhelm",
            Category.HELMET,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.CHAINMAIL_HELMET),
            new ItemStack(Material.CHAINMAIL_HELMET)
    )),
    CHAIN_CHEST_PLATE(new ClassicArmorCosmetic(
            6,
            "Kettenbrustplatte",
            Category.CHEST_PLATE,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.CHAINMAIL_CHESTPLATE),
            new ItemStack(Material.CHAINMAIL_CHESTPLATE)
    )),
    CHAIN_PANTS(new ClassicArmorCosmetic(
            7,
            "Kettenhose",
            Category.PANTS,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.CHAINMAIL_LEGGINGS),
            new ItemStack(Material.CHAINMAIL_LEGGINGS)
    )),
    CHAIN_SHOES(new ClassicArmorCosmetic(
            8,
            "Kettenschuhe",
            Category.SHOES,
            1000,
            Rarity.COMMON,
            new ItemStack(Material.CHAINMAIL_BOOTS),
            new ItemStack(Material.CHAINMAIL_BOOTS)
    ));

    private ClassicArmorCosmetic classicArmor;

    ClassicArmor(ClassicArmorCosmetic classicArmor) {
        this.classicArmor = classicArmor;
    }

    public ClassicArmorCosmetic getClassicArmor() {
        return classicArmor;
    }

}
