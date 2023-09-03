package de.groodian.hyperiorcosmetics.cosmetic;

public enum Category {

    PARTICLE("Partikel"),
    BLOCK("Blockspur"),
    HELMET("Helm"),
    CHEST_PLATE("Brustplatte"),
    PANTS("Hose"),
    SHOES("Schuhe"),
    GADGET("Gadget");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
