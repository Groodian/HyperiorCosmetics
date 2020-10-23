package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.suit.SuitCollection;
import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.inventory.Inventory;

public class SuitMenu extends CosmeticMenu {

    private static final int SUITS_PER_PAGE = 5;
    private static final int LEFT_OFFSET = 2;

    private SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection) {
        super(hyperiorCosmetic, "Anzüge", Category.HELMET, Category.CHEST_PLATE, Category.PANTS, Category.SHOES);
        this.suitCollection = suitCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        int suitPos = (page - 1) * SUITS_PER_PAGE;
        for (int i = 0; i < SUITS_PER_PAGE; i++) {
            if (suitPos >= suitCollection.values().size()) {
                break;
            }
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(suitPos).getHelmetSlot(), i + LEFT_OFFSET, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(suitPos).getChestPlateSlot(), i + LEFT_OFFSET + 9, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(suitPos).getPantsSlot(), i + LEFT_OFFSET + 18, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(suitPos).getShoesSlot(), i + LEFT_OFFSET + 27, page);
            suitPos++;
        }
    }

}
