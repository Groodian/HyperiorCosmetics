package de.groodian.cosmetics.cosmetic;

import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class Cosmetic {

    private static final List<Cosmetic> cosmetics = new ArrayList<>();

    protected Class<? extends CosmeticHandler<?>> clazz;
    protected int id;
    protected String name;
    protected Category category;
    protected Rarity rarity;
    protected int updateRate;
    protected ItemStack inventoryItem;

    public Cosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Category category, Rarity rarity, int updateRate, ItemStack inventoryItem) {
        this.clazz = clazz;
        this.id = id;
        this.name = name;
        this.category = category;
        this.rarity = rarity;
        this.updateRate = updateRate;
        this.inventoryItem = inventoryItem;

        cosmetics.add(this);
        inventoryItem = new ItemBuilder(inventoryItem).setName(rarity.getColor() + name).setLore(
                " ",
                "�7Seltenheit: " + rarity.getColor() + rarity.getName(),
                "�7Kategorie: " + category.getName(),
                "�7Preis: �e" + getPrice() + " Coins"
        ).build();
    }

    public Class<? extends CosmeticHandler<?>> getClazz() {
        return clazz;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return rarity.getPrice();
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpdateRate() {
        return updateRate;
    }

    public ItemStack getInventoryItem() {
        return inventoryItem;
    }

    public static Cosmetic getCosmeticsById(int id) {
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getId() == id) {
                return cosmetic;
            }
        }
        return null;
    }

    public static List<Cosmetic> getCosmetics() {
        return cosmetics;
    }

}
