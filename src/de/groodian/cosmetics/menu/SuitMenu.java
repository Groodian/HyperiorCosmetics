package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.suit.Suit;
import de.groodian.cosmetics.suit.SuitCollection;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class SuitMenu extends CosmeticMenu {

    private SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection) {
        super(hyperiorCosmetic, "Cosmetic > Anzüge");
        this.suitCollection = suitCollection;
    }

    @Override
    protected void setCosmetics(CosmeticPlayer cosmeticPlayer, Inventory inventory) {
        int count = 0;
        for (Suit suit : suitCollection.values()) {
            if (count < 9) {
                inventory.setItem(count, getEditedItem(suit.getHelmetSlot()));
                inventory.setItem(count + 9, getEditedItem(suit.getChestPlateSlot()));
                inventory.setItem(count + 18, getEditedItem(suit.getPantsSlot()));
                inventory.setItem(count + 27, getEditedItem(suit.getShoesSlot()));
                count++;
            } else {
                break;
            }
        }
    }

    @Override
    public void handleCosmeticClick(ClickData clickData) {
        for (Suit suit : suitCollection.values()) {
            for (Cosmetic cosmetic : suit.getAsList()) {
                if (cosmetic.getName().equals(ChatColor.stripColor(clickData.getItemStack().getItemMeta().getDisplayName()))) {
                    clickData.getCosmeticPlayer().equip(cosmetic);
                    break;
                }
            }
        }
    }

}
