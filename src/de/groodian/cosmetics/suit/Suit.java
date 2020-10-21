package de.groodian.cosmetics.suit;

import de.groodian.cosmetics.Cosmetic;

import java.util.Arrays;
import java.util.List;

public class Suit {

    private Cosmetic helmetSlot;
    private Cosmetic chestPlateSlot;
    private Cosmetic pantsSlot;
    private Cosmetic shoesSlot;

    public Suit(Cosmetic helmetSlot, Cosmetic chestPlateSlot, Cosmetic pantsSlot, Cosmetic shoesSlot) {
        this.helmetSlot = helmetSlot;
        this.chestPlateSlot = chestPlateSlot;
        this.pantsSlot = pantsSlot;
        this.shoesSlot = shoesSlot;
    }

    public List<Cosmetic> getAsList() {
        return Arrays.asList(helmetSlot, chestPlateSlot, pantsSlot, shoesSlot);
    }

    public Cosmetic getHelmetSlot() {
        return helmetSlot;
    }

    public Cosmetic getChestPlateSlot() {
        return chestPlateSlot;
    }

    public Cosmetic getPantsSlot() {
        return pantsSlot;
    }

    public Cosmetic getShoesSlot() {
        return shoesSlot;
    }

}
