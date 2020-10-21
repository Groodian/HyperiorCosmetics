package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticCollection;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.inventory.Inventory;

public class DefaultCosmeticMenu extends CosmeticMenu {

    private CosmeticCollection<? extends Cosmetic> cosmeticCollection;

    public DefaultCosmeticMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticCollection<? extends Cosmetic> cosmeticCollection) {
        super(hyperiorCosmetic, "Cosmetic > " + cosmeticCollection.getName());
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory) {
        int count = 0;
        for (Cosmetic cosmetic : cosmeticCollection.values()) {
            if (count < 27) {
                inventory.setItem(count, getEditedItem(cosmetic));
                count++;
            } else {
                break;
            }
        }
    }

    @Override
    public void handleCosmeticClick(ClickData clickData) {
        for (Cosmetic cosmetic : cosmeticCollection.values()) {
            if (cosmetic.getInventoryItem().getItemMeta().getDisplayName().equals(clickData.getItemStack().getItemMeta().getDisplayName())) {
                clickData.getCosmeticPlayer().equip(cosmetic);
                break;
            }
        }
    }

}
