package de.groodian.cosmetics;

public enum Rarity {

    COMMON("§7Gewöhnlich"),
    UNCOMMON("§aUngewöhnlich"),
    RARE("§9Selten"),
    EPIC("§dEpisch"),
    LEGENDARY("§bLegendär"),
    MYSTIC("§6Mystisch"),
    BLACK_MARKET("§cSchwarzmarktware");

    private String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
