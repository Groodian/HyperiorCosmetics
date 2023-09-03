package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcore.util.ColoredMaterial;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticCollection;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Tag;

public class BlockCollection extends CosmeticCollection {

    public BlockCollection() {
        super("Blöcke", Category.BLOCK);
    }

    @Override
    protected List<Cosmetic> registerValues() {
        return Arrays.asList(
                new ClassicBlockCosmetic(
                        ClassicBlockHandler.class,
                        101,
                        "Goldblock Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.GOLD_BLOCK).build(),
                        false,
                        Material.GOLD_BLOCK
                ),
                new ClassicBlockCosmetic(
                        ClassicBlockHandler.class,
                        102,
                        "Bedrock Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.BEDROCK).build(),
                        false,
                        Material.BEDROCK
                ),
                new ClassicBlockCosmetic(
                        ClassicBlockHandler.class,
                        103,
                        "Golddruckplatten Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.LIGHT_WEIGHTED_PRESSURE_PLATE).build(),
                        true,
                        Material.LIGHT_WEIGHTED_PRESSURE_PLATE
                ),
                new ClassicBlockCosmetic(
                        GrowBlockHandler.class,
                        104,
                        "Karotten Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.GOLDEN_CARROT).build(),
                        true,
                        Material.CARROTS
                ),
                new ClassicBlockCosmetic(
                        GrowBlockHandler.class,
                        105,
                        "Kartoffel Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.POTATO).build(),
                        true,
                        Material.POTATOES
                ),
                new ClassicBlockCosmetic(
                        GrowBlockHandler.class,
                        106,
                        "Netherwarzen Spur",
                        Rarity.RARE,
                        new ItemBuilder(Material.NETHER_WART).build(),
                        true,
                        Material.NETHER_WART
                ),
                new ClassicBlockCosmetic(
                        ClassicBlockHandler.class,
                        107,
                        "Blut Spur",
                        Rarity.EPIC,
                        new ItemBuilder(Material.REDSTONE).build(),
                        true,
                        Material.REDSTONE_WIRE
                ),
                new ClassicBlockCosmetic(
                        GrowBlockHandler.class,
                        108,
                        "Getreide Spur",
                        Rarity.EPIC,
                        new ItemBuilder(Material.WHEAT).build(),
                        true,
                        Material.WHEAT
                ),
                new AdvancedBlockCosmetic(
                        AdvancedBlockHandler.class,
                        109,
                        "Regenbogen Wolle Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.CYAN_WOOL).build(),
                        false,
                        Tag.WOOL.getValues().stream().toList()
                ),
                new AdvancedBlockCosmetic(
                        AdvancedBlockHandler.class,
                        110,
                        "Regenbogen Lehm Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.PURPLE_TERRACOTTA).build(),
                        false,
                        ColoredMaterial.get("_TERRACOTTA")
                ),
                new AdvancedBlockCosmetic(
                        AdvancedBlockHandler.class,
                        111,
                        "Regenbogen Glas Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.LIME_STAINED_GLASS).build(),
                        false,
                        ColoredMaterial.get("_STAINED_GLASS")
                ),
                new AdvancedBlockCosmetic(
                        AdvancedBlockHandler.class,
                        112,
                        "Regenbogen Teppich Spur",
                        Rarity.LEGENDARY,
                        new ItemBuilder(Material.LIGHT_BLUE_CARPET).build(),
                        true,
                        Tag.WOOL_CARPETS.getValues().stream().toList()
                ),
                new ClassicBlockCosmetic(
                        ClassicBlockHandler.class,
                        113,
                        "Endportal Spur",
                        Rarity.MYSTIC,
                        new ItemBuilder(Material.END_PORTAL_FRAME).build(),
                        true,
                        Material.END_PORTAL
                )
        );
    }

}
