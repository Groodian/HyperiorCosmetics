package de.groodian.cosmetics.cosmetic;

public enum Rarity {

    COMMON("Gewöhnlich", "§7", 1500),
    UNCOMMON("Ungewöhnlich", "§a", 3000),
    RARE("Selten", "§9", 6000),
    EPIC("Episch", "§d", 24000),
    LEGENDARY("Legendär", "§b", 48000),
    MYSTIC("Mystisch", "§6", 150000),
    BLACK_MARKET("Schwarzmarktware", "§c", 200000);

    private String name;
    private String color;
    private int price;

    Rarity(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

}
