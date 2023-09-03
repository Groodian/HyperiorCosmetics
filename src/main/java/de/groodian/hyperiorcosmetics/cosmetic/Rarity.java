package de.groodian.hyperiorcosmetics.cosmetic;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;

public enum Rarity {

    COMMON("Gewöhnlich", NamedTextColor.GRAY, 1500, 200, 5700, Material.GRAY_STAINED_GLASS_PANE),
    UNCOMMON("Ungewöhnlich", NamedTextColor.GREEN, 3000, 400, 2500, Material.LIME_STAINED_GLASS_PANE),
    RARE("Selten", NamedTextColor.BLUE, 6000, 800, 1300, Material.BLUE_STAINED_GLASS_PANE),
    EPIC("Episch", NamedTextColor.LIGHT_PURPLE, 24000, 3200, 300, Material.MAGENTA_STAINED_GLASS_PANE),
    LEGENDARY("Legendär", NamedTextColor.AQUA, 48000, 6400, 150, Material.LIGHT_BLUE_STAINED_GLASS_PANE),
    MYSTIC("Mystisch", NamedTextColor.GOLD, 150000, 30000, 40, Material.YELLOW_STAINED_GLASS_PANE),
    BLACK_MARKET("Schwarzmarktware", NamedTextColor.RED, 200000, 50000, 10, Material.RED_STAINED_GLASS_PANE);

    private final String name;
    private final TextColor color;
    private final int price;
    private final int sellPrice;
    private final int chance;
    private final Material material;

    Rarity(String name, TextColor color, int price, int sellPrice, int chance, Material material) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.sellPrice = sellPrice;
        this.chance = chance;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public TextColor getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getChance() {
        return chance;
    }

    public Material getMaterial() {
        return material;
    }

}
