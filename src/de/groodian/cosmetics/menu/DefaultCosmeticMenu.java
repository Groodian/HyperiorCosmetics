package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.inventory.Inventory;

public class DefaultCosmeticMenu extends CosmeticMenu {

    private static final int[] cosmeticSlots = new int[]{
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25
    };

    private CosmeticCollection cosmeticCollection;

    public DefaultCosmeticMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticCollection cosmeticCollection) {
        super(hyperiorCosmetic, cosmeticCollection.getName(), cosmeticCollection.getCategory());
        this.cosmeticCollection = cosmeticCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        int cosmeticPos = (page - 1) * cosmeticSlots.length;
        for (int i = 0; i < cosmeticSlots.length; i++) {
            if (i >= cosmeticCollection.values().size()) {
                break;
            }
            putCosmetic(cosmeticPlayer, inventory, cosmeticCollection.values().get(cosmeticPos), cosmeticSlots[i], page);
            cosmeticPos++;
        }
    }

}
