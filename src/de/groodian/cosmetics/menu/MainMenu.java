package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.block.BlockCollection;
import de.groodian.cosmetics.cosmetic.suit.SuitCollection;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    private static final ItemStack DEACTIVATE_ALL = new ItemBuilder(Material.BARRIER).setName("§cDeaktiviere alle Kosmetik").build();

    private List<MenuCategory> menuCategories;

    public MainMenu(HyperiorCosmetic hyperiorCosmetic) {
        super(hyperiorCosmetic, "Kosmetik", 54);

        menuCategories = Arrays.asList(
                new MenuCategory(new ItemBuilder(Material.REDSTONE).setName("§aPartikel").build(), 11, new DefaultCosmeticMenu(hyperiorCosmetic, new PlaceHolder())),
                new MenuCategory(new ItemBuilder(Material.GOLD_BLOCK).setName("§aBlockspuren").build(), 15, new DefaultCosmeticMenu(hyperiorCosmetic, new BlockCollection())),
                new MenuCategory(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("§aAnzüge").build(), 29, new SuitMenu(hyperiorCosmetic, new SuitCollection())),
                new MenuCategory(new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("§aGadgets").build(), 33, new DefaultCosmeticMenu(hyperiorCosmetic, new PlaceHolder()))
        );

    }

    @Override
    protected void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page) {
        putItem(inventory, DEACTIVATE_ALL, 49, clickData -> clickData.getCosmeticPlayer().disableAll());
        for (MenuCategory menuCategory : menuCategories) {
            putItem(inventory, menuCategory.getItemStack(), menuCategory.getSlot(), clickData -> menuCategory.getMenu().open(cosmeticPlayer));
            inventory.setItem(menuCategory.getSlot(), menuCategory.getItemStack());
        }
    }

}
