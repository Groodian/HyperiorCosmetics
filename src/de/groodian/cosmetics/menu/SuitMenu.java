package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.suit.SuitCollection;
import org.bukkit.inventory.Inventory;

public class SuitMenu extends CosmeticMenu {

    private SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection) {
        super(hyperiorCosmetic, "Anzüge", Category.HELMET, Category.CHEST_PLATE, Category.PANTS, Category.SHOES);
        this.suitCollection = suitCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        for (int i = (page - 1) * 9; i < page * 9; i++) {
            if (i >= suitCollection.values().size()) {
                break;
            }
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getHelmetSlot(), i - ((page - 1) * 27), page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getChestPlateSlot(), i - ((page - 1) * 27) + 9, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getPantsSlot(), i - ((page - 1) * 27) + 18, page);
            putCosmetic(cosmeticPlayer, inventory, suitCollection.values().get(i).getShoesSlot(), i - ((page - 1) * 27) + 27, page);
        }
    }

}
