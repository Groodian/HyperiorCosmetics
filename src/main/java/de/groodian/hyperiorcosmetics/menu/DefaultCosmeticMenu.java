package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticCollection;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

public class DefaultCosmeticMenu extends CosmeticMenu {

    private static final int[] cosmeticSlots = new int[]{
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25
    };

    private final CosmeticCollection cosmeticCollection;

    public DefaultCosmeticMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticCollection cosmeticCollection, CosmeticPlayer cosmeticPlayer,
                               int page) {
        super(hyperiorCosmetic, cosmeticCollection.getName(), cosmeticPlayer, page, cosmeticCollection.getCategory());
        this.cosmeticCollection = cosmeticCollection;
    }

    @Override
    protected void setCosmetics() {
        int cosmeticPos = (page - 1) * cosmeticSlots.length;
        for (int cosmeticSlot : cosmeticSlots) {
            if (cosmeticPos >= cosmeticCollection.values().size()) {
                break;
            }
            putCosmetic(cosmeticCollection.values().get(cosmeticPos), cosmeticSlot);
            cosmeticPos++;
        }
    }

    @Override
    protected GUI newGUIForPage(int page) {
        return new DefaultCosmeticMenu(hyperiorCosmetic, cosmeticCollection, cosmeticPlayer, page);
    }

}
