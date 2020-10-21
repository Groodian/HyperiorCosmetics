package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticCollection;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.inventory.Inventory;

public class DefaultCosmeticMenu extends CosmeticMenu {

    private CosmeticCollection<? extends Cosmetic> cosmeticCollection;

    public DefaultCosmeticMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticCollection<? extends Cosmetic> cosmeticCollection) {
        super(hyperiorCosmetic, cosmeticCollection.getName(), cosmeticCollection.getCategory());
        this.cosmeticCollection = cosmeticCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        for (int i = (page - 1) * 27; i < page * 27; i++) {
            if (i >= cosmeticCollection.values().size()) {
                break;
            }
            final int finalI = i;
            putItem(inventory, getEditedItem(cosmeticCollection.values().get(i)), i - ((page - 1) * 27), clickData -> cosmeticPlayer.equip(cosmeticCollection.values().get(finalI)));
        }
    }

}
