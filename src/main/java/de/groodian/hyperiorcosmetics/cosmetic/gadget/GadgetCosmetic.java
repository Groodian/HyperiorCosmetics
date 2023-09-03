package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;

public class GadgetCosmetic extends Cosmetic {

    private final ItemStack gadgetItem;
    private final int gadgetUpdateRate;
    private final int delay;

    public GadgetCosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Rarity rarity, int gadgetUpdateRate, int delay,
                          ItemStack inventoryItem, ItemStack gadgetItem) {
        super(clazz, id, name, Category.GADGET, rarity, 1, inventoryItem);
        this.gadgetUpdateRate = gadgetUpdateRate;
        this.gadgetItem = new ItemBuilder(gadgetItem.clone())
                .setName(Component.text(getName(), getRarity().getColor()).decoration(TextDecoration.BOLD, true)
                        .append(Component.text(" (Rechtsklick)", NamedTextColor.GRAY).decoration(TextDecoration.BOLD, false)))
                .setLore(super.inventoryItem.getItemMeta().lore())
                .build();
        this.delay = delay;
    }

    public int getGadgetUpdateRate() {
        return gadgetUpdateRate;
    }

    public int getDelay() {
        return delay;
    }

    public ItemStack getGadgetItem() {
        return gadgetItem;
    }

}
