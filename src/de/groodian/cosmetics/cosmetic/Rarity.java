package de.groodian.cosmetics.cosmetic;

public enum Rarity {

    COMMON("Gewöhnlich", "§7", 1500, 200, 5700, 7),
    UNCOMMON("Ungewöhnlich", "§a", 3000, 400, 2500, 5),
    RARE("Selten", "§9", 6000, 800, 1300, 11),
    EPIC("Episch", "§d", 24000, 3200, 300, 2),
    LEGENDARY("Legendär", "§b", 48000, 6400, 150, 3),
    MYSTIC("Mystisch", "§6", 150000, 30000, 40, 4),
    BLACK_MARKET("Schwarzmarktware", "§c", 200000, 50000, 10, 14);

    private String name;
    private String color;
    private int price;
    private int sellPrice;
    private int chance;
    private short subId;

    Rarity(String name, String color, int price, int sellPrice, int chance, int subId) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.sellPrice = sellPrice;
        this.chance = chance;
        this.subId = (short) subId;
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

    public int getSellPrice() {
        return sellPrice;
    }

    public int getChance() {
        return chance;
    }

    public short getSubId() {
        return subId;
    }

}
