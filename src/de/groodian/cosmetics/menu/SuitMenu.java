package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.suit.SuitCollection;
import org.bukkit.inventory.Inventory;

public class SuitMenu extends CosmeticMenu {

    private static final int SUITS_PER_PAGE = 9;

    private SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection) {
        super(hyperiorCosmetic, "Anzüge", Category.HELMET, Category.CHEST_PLATE, Category.PANTS, Category.SHOES);
        this.suitCollection = suitCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        for (int i = (page - 1) * SUITS_PER_PAGE; i < page * SUITS_PER_PAGE; i++) {
            if (i >= suitCollection.values().size()) {
                break;
            }
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getHelmetSlot(), i - ((page - 1) * SUITS_PER_PAGE), page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getChestPlateSlot(), i - ((page - 1) * SUITS_PER_PAGE) + 9, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getPantsSlot(), i - ((page - 1) * SUITS_PER_PAGE) + 18, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getShoesSlot(), i - ((page - 1) * SUITS_PER_PAGE) + 27, page);
        }
    }

}
