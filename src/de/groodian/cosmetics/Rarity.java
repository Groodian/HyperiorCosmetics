package de.groodian.cosmetics;

public enum Rarity {

    COMMON("Gew�hnlich", "�7"),
    UNCOMMON("Ungew�hnlich", "�a"),
    RARE("Selten", "�9"),
    EPIC("Episch", "�d"),
    LEGENDARY("Legend�r", "�b"),
    MYSTIC("Mystisch", "�6"),
    BLACK_MARKET("Schwarzmarktware", "�c");

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
