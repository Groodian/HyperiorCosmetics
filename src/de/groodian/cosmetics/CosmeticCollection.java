package de.groodian.cosmetics;

import java.util.ArrayList;
import java.util.List;

public abstract class CosmeticCollection<T extends Cosmetic> {

    private String name;
    protected List<T> values;

    public CosmeticCollection(String name) {
        this.name = name;
    }

    public List<T> values() {
        if (values == null) {
            values = new ArrayList<>();
            registerValues();
        }
        return values;
    }

    protected abstract void registerValues();

    public String getName() {
        return name;
    }

}
