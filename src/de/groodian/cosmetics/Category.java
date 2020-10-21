package de.groodian.cosmetics;

public enum Category {

    PARTICLE("Partikel"),
    BLOCK("Blockspur"),
    HELMET("Helm"),
    CHEST_PLATE("Brustplatte"),
    PANTS("Hose"),
    SHOES("Schuhe"),
    GADGET("Gadget");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
