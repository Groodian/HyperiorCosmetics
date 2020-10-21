package de.groodian.cosmetics;

public enum Rarity {

    COMMON("Gewöhnlich", "§7"),
    UNCOMMON("Ungewöhnlich", "§a"),
    RARE("Selten", "§9"),
    EPIC("Episch", "§d"),
    LEGENDARY("Legendär", "§b"),
    MYSTIC("Mystisch", "§6"),
    BLACK_MARKET("Schwarzmarktware", "§c");

    private String name;
    private String color;

    Rarity(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

}
