package de.groodian.cosmetics;

import org.bukkit.inventory.ItemStack;

public abstract class Cosmetic {

    protected Class<? extends CosmeticHandler<?>> clazz;
    protected int id;
    protected String name;
    protected Category category;
    protected int price;
    protected Rarity rarity;
    protected ItemStack inventoryItem;

    public Cosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Category category, int price, Rarity rarity, ItemStack inventoryItem) {
        this.clazz = clazz;
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rarity = rarity;
        this.inventoryItem = inventoryItem;
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
        return price;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public ItemStack getInventoryItem() {
        return inventoryItem;
    }

}
