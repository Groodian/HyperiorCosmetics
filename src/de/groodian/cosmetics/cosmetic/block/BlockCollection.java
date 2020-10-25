package de.groodian.cosmetics.cosmetic.block;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class BlockCollection extends CosmeticCollection {

    public BlockCollection() {
        super("Blöcke", Category.BLOCK);
    }

    @Override
    protected List<Cosmetic> registerValues() {
        return Arrays.asList(
                new BlockCosmetic(
                        ClassicBlockHandler.class,
                        101,
                        "Goldblock Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.GOLD_BLOCK).build(),
                        false,
                        Material.GOLD_BLOCK,
                        (byte) 0
                ),
                new BlockCosmetic(
                        ClassicBlockHandler.class,
                        102,
                        "Bedrock Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.BEDROCK).build(),
                        false,
                        Material.BEDROCK,
                        (byte) 0
                ),
                new BlockCosmetic(
                        ClassicBlockHandler.class,
                        103,
                        "Golddruckplatten Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.GOLD_PLATE).build(),
                        true,
                        Material.GOLD_PLATE,
                        (byte) 0
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        104,
                        "Karotten Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.GOLDEN_CARROT).build(),
                        true,
                        Material.CARROT,
                        (byte) 8
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        105,
                        "Kartoffel Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.POTATO_ITEM).build(),
                        true,
                        Material.POTATO,
                        (byte) 8
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        106,
                        "Netherwarzen Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.NETHER_STALK).build(),
                        true,
                        Material.NETHER_WARTS,
                        (byte) 4
                ),
                new BlockCosmetic(
                        ClassicBlockHandler.class,
                        107,
                        "Blut Spur",
                        Rarity.EPIC,
                        new ItemBuilder(Material.REDSTONE).build(),
                        true,
                        Material.REDSTONE_WIRE,
                        (byte) 0
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        108,
                        "Getreide Spur",
                        Rarity.EPIC,
                        new ItemBuilder(Material.WHEAT).build(),
                        true,
                        Material.CROPS,
                        (byte) 8
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        109,
                        "Regenbogen Wolle Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.WOOL, (short) 9).build(),
                        false,
                        Material.WOOL,
                        (byte) 16
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        110,
                        "Regenbogen Lehm Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.STAINED_CLAY, (short) 10).build(),
                        false,
                        Material.STAINED_CLAY,
                        (byte) 16
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        111,
                        "Regenbogen Glas Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.STAINED_GLASS, (short) 5).build(),
                        false,
                        Material.STAINED_GLASS,
                        (byte) 16
                ),
                new BlockCosmetic(
                        AdvancedBlockHandler.class,
                        112,
                        "Regenbogen Teppich Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.CARPET, (short) 3).build(),
                        true,
                        Material.CARPET,
                        (byte) 16
                ),
                new BlockCosmetic(
                        ClassicBlockHandler.class,
                        113,
                        "Endportal Spur",
                        Rarity.MYSTIC,
                        new ItemBuilder(Material.ENDER_PORTAL_FRAME).build(),
                        true,
                        Material.ENDER_PORTAL,
                        (byte) 0
                )
        );
    }

}
