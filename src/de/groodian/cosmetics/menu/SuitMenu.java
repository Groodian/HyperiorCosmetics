package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.Cosmetic;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.suit.Suit;
import de.groodian.cosmetics.suit.SuitCollection;
import org.bukkit.inventory.Inventory;

public class SuitMenu extends Menu {

    private SuitCollection suitCollection;

    public SuitMenu(HyperiorCosmetic hyperiorCosmetic, SuitCollection suitCollection) {
        super(hyperiorCosmetic, "Cosmetic > Anzüge", 54);
        this.suitCollection = suitCollection;
    }

    @Override
    protected void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory) {
        int count = 0;
        for (Suit suit : suitCollection.values()) {
            if (count < 9) {
                inventory.setItem(count, suit.getHelmetSlot().getInventoryItem());
                inventory.setItem(count + 9, suit.getChestPlateSlot().getInventoryItem());
                inventory.setItem(count + 18, suit.getPantsSlot().getInventoryItem());
                inventory.setItem(count + 27, suit.getShoesSlot().getInventoryItem());
                count++;
            } else {
                break;
            }
        }
    }

    @Override
    public void handleClick(ClickData clickData) {
        for (Suit suit : suitCollection.values()) {
            for (Cosmetic cosmetic : suit.getAsList()) {
                if (cosmetic.getInventoryItem().getItemMeta().getDisplayName().equals(clickData.getItemStack().getItemMeta().getDisplayName())) {
                    clickData.getCosmeticPlayer().equip(cosmetic);
                    break;
                }
            }
        }
    }

}
