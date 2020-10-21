package de.groodian.cosmetics;

import java.util.List;

public abstract class CosmeticCollection<T extends Cosmetic> {

    private String name;
    private List<T> values;

    public CosmeticCollection(String name) {
        this.name = name;
        values = registerValues();
    }

    public List<T> values() {
        return values;
    }

    protected abstract List<T> registerValues();

    public String getName() {
        return name;
    }

}
