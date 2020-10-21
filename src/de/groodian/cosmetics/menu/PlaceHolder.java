package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.CosmeticCollection;
import de.groodian.cosmetics.suit.ClassicSuitCosmetic;

import java.util.Collections;
import java.util.List;

public class PlaceHolder extends CosmeticCollection<ClassicSuitCosmetic> {

    public PlaceHolder() {
        super("PlaceHolder");
    }

    @Override
    protected List<ClassicSuitCosmetic> registerValues() {
        return Collections.emptyList();
    }

}
