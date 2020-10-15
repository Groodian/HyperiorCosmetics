package de.groodian.cosmetics;

public enum Rarity {

    COMMON("�7Gew�hnlich"),
    UNCOMMON("�aUngew�hnlich"),
    RARE("�9Selten"),
    EPIC("�dEpisch"),
    LEGENDARY("�bLegend�r"),
    MYSTIC("�6Mystisch"),
    BLACK_MARKET("�cSchwarzmarktware");

    private String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
