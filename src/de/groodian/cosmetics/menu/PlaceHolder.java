package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.cosmetic.Category;
import de.groodian.cosmetics.cosmetic.CosmeticCollection;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.cosmetics.cosmetic.suit.ClassicSuitCosmetic;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PlaceHolder extends CosmeticCollection<ClassicSuitCosmetic> {

    public PlaceHolder() {
        super("PlaceHolder", Category.BLOCK);
    }

    @Override
    protected List<ClassicSuitCosmetic> registerValues() {
        ArrayList<ClassicSuitCosmetic> returnValue = new ArrayList<>();
        returnValue.add(new ClassicSuitCosmetic(
                1,
                "Lederhelm",
                Category.HELMET,
                Rarity.COMMON,
                new ItemStack(Material.LEATHER_HELMET),
                new ItemStack(Material.LEATHER_HELMET)
        ));
        return returnValue;
    }

}
