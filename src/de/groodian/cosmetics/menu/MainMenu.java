package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.suit.SuitCollection;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    private List<MenuCategory> menuCategories;

    public MainMenu(HyperiorCosmetic hyperiorCosmetic) {
        super(hyperiorCosmetic, "Cosmetic", 18);

        menuCategories = Arrays.asList(
                new MenuCategory(new ItemBuilder(Material.REDSTONE).setName("Partikel").build(), 10, new DefaultCosmeticMenu(hyperiorCosmetic, new PlaceHolder())),
                new MenuCategory(new ItemBuilder(Material.GOLD_BLOCK).setName("Blockspuren").build(), 11, new DefaultCosmeticMenu(hyperiorCosmetic, new PlaceHolder())),
                new MenuCategory(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("Anzüge").build(), 12, new SuitMenu(hyperiorCosmetic, new SuitCollection())),
                new MenuCategory(new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("Gadgets").build(), 13, new DefaultCosmeticMenu(hyperiorCosmetic, new PlaceHolder()))
        );

    }

    @Override
    protected void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory) {
        for (MenuCategory menuCategory : menuCategories) {
            inventory.setItem(menuCategory.getSlot(), menuCategory.getItemStack());
        }
    }

    @Override
    public void handleClick(ClickData clickData) {
        for (MenuCategory menuCategory : menuCategories) {
            if (menuCategory.getItemStack().getItemMeta().getDisplayName().equals(clickData.getItemStack().getItemMeta().getDisplayName()) && menuCategory.getSlot() == clickData.getSlot()) {
                menuCategory.getMenu().open(clickData.getCosmeticPlayer());
                break;
            }
        }
    }

}
