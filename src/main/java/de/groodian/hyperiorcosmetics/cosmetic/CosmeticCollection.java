package de.groodian.hyperiorcosmetics.cosmetic;

import java.util.List;

public abstract class CosmeticCollection {

    private final String name;
    private final Category category;
    private final List<Cosmetic> values;

    public CosmeticCollection(String name, Category category) {
        this.name = name;
        this.category = category;
        values = registerValues();
    }

    public List<Cosmetic> values() {
        return values;
    }

    protected abstract List<Cosmetic> registerValues();

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

}
