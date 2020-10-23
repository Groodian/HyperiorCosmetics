package de.groodian.cosmetics.cosmetic;

import java.util.List;

public abstract class CosmeticCollection<T extends Cosmetic> {

    private String name;
    private Category category;
    private List<T> values;

    public CosmeticCollection(String name, Category category) {
        this.name = name;
        this.category = category;
        values = registerValues();
    }

    public List<T> values() {
        return values;
    }

    protected abstract List<T> registerValues();

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

}
