package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.suit.SuitCollection;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

public class SuitMenu extends CosmeticMenu {

    private static final int SUITS_PER_PAGE = 5;
    private static final int LEFT_OFFSET = 2;

    private final SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection, CosmeticPlayer cosmeticPlayer, int page) {
        super(hyperiorCosmetic, "Anzüge", cosmeticPlayer, page, Category.HELMET, Category.CHEST_PLATE, Category.PANTS, Category.SHOES);
        this.suitCollection = suitCollection;
    }

    @Override
    protected void setCosmetics() {
        int suitPos = (page - 1) * SUITS_PER_PAGE;
        for (int i = 0; i < SUITS_PER_PAGE; i++) {
            if (suitPos >= suitCollection.values().size()) {
                break;
            }
            putCosmetic(suitCollection.values().get(suitPos).getHelmetSlot(), i + LEFT_OFFSET);
            putCosmetic(suitCollection.values().get(suitPos).getChestPlateSlot(), i + LEFT_OFFSET + 9);
            putCosmetic(suitCollection.values().get(suitPos).getPantsSlot(), i + LEFT_OFFSET + 18);
            putCosmetic(suitCollection.values().get(suitPos).getShoesSlot(), i + LEFT_OFFSET + 27);
            suitPos++;
        }
    }

    @Override
    protected GUI newGUIForPage(int page) {
        return new SuitMenu(hyperiorCosmetic, suitCollection, cosmeticPlayer, page);
    }

}
