package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.player.CosmeticPlayer;
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
            putCosmetic(cosmeticPlayer, inventory, cosmeticCollection.values().get(i), i - ((page - 1) * 27), page);
        }
    }

}
