package de.groodian.hyperiorcosmetics.cosmetic;

import de.groodian.hyperiorcore.util.ItemBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.inventory.ItemStack;

public abstract class Cosmetic {

    private static final List<Cosmetic> cosmetics = new ArrayList<>();

    protected Class<? extends CosmeticHandler<?>> clazz;
    protected int id;
    protected String name;
    protected Category category;
    protected Rarity rarity;
    protected int updateRate;
    protected ItemStack inventoryItem;

    public Cosmetic(Class<? extends CosmeticHandler<?>> clazz, int id, String name, Category category, Rarity rarity, int updateRate,
                    ItemStack inventoryItem) {
        this.clazz = clazz;
        this.id = id;
        this.name = name;
        this.category = category;
        this.rarity = rarity;
        this.updateRate = updateRate;
        this.inventoryItem = new ItemBuilder(inventoryItem.clone())
                .setName(Component.text(name, rarity.getColor()))
                .setLore(Component.empty(),
                        Component.text("Seltenheit: ", NamedTextColor.GRAY).append(Component.text(rarity.getName(), rarity.getColor())),
                        Component.text("Kategorie: " + category.getName(), NamedTextColor.GRAY),
                        Component.text("Preis: ", NamedTextColor.GRAY).append(Component.text(getPrice() + " Coins", NamedTextColor.YELLOW)))
                .build();

        cosmetics.add(this);
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

    public static Cosmetic getRandomCosmetic(Random random) {
        int total = 0;
        for (Rarity rarity : Rarity.values()) {
            total += rarity.getChance();
        }
        int randomInt = random.nextInt(total) + 1;
        int chanceOff = 0;
        Rarity cosmeticRarity = null;
        for (Rarity rarity : Rarity.values()) {
            if (randomInt <= rarity.getChance() + chanceOff) {
                cosmeticRarity = rarity;
                break;
            }
            chanceOff += rarity.getChance();
        }

        List<Cosmetic> cosmeticsWithRarity = new ArrayList<>();
        for (Cosmetic cosmetic : Cosmetic.getCosmetics()) {
            if (cosmetic.getRarity() == cosmeticRarity) {
                cosmeticsWithRarity.add(cosmetic);
            }
        }

        return cosmeticsWithRarity.get(random.nextInt(cosmeticsWithRarity.size()));
    }

}
