package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticCollection;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.inventory.Inventory;

public class CosmeticMenu extends Menu {

    private CosmeticCollection<? extends Cosmetic> cosmeticCollection;

    public CosmeticMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticCollection<? extends Cosmetic> cosmeticCollection) {
        super(hyperiorCosmetic, "Cosmetic > " + cosmeticCollection.getName(), 45);
        this.cosmeticCollection = cosmeticCollection;
    }

    @Override
    protected void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory) {
        int count = 0;
        for (Cosmetic cosmetic : cosmeticCollection.values()) {
            if (count < 27) {
                inventory.setItem(count, cosmetic.getInventoryItem());
                count++;
            } else {
                break;
            }
        }
    }

    @Override
    public void handleClick(ClickData clickData) {
        for (Cosmetic cosmetic : cosmeticCollection.values()) {
            if (cosmetic.getInventoryItem().getItemMeta().getDisplayName().equals(clickData.getItemStack().getItemMeta().getDisplayName())) {
                clickData.getCosmeticPlayer().equip(cosmetic);
                break;
            }
        }
    }

}
