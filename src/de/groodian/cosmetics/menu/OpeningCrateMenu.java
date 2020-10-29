package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.Rarity;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpeningCrateMenu extends Menu {

    private static final int[] DELAYS = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 10, 15, 15};

    private Random random;

    public OpeningCrateMenu(HyperiorCosmetic hyperiorCosmetic) {
        super(hyperiorCosmetic, "Öffne Kiste...", 45);
        random = new Random();
    }

    @Override
    protected void putItems(final CosmeticPlayer cosmeticPlayer, final Inventory inventory, final int page) {
        putItem(inventory, new ItemBuilder(Material.NETHER_STAR).setName("§7Dein Gewinn:").build(), 4, null);
        putItem(inventory, new ItemBuilder(Material.NETHER_STAR).setName("§7Dein Gewinn:").build(), 40, null);
        List<Cosmetic> cosmetics = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cosmetics.add(getRandomCosmetic());
        }
        setCosmetic(inventory, cosmetics);
        nextTick(cosmeticPlayer, inventory, cosmetics, 0);
    }

    private void nextTick(final CosmeticPlayer cosmeticPlayer, final Inventory inventory, final List<Cosmetic> cosmetics, final int pos) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(hyperiorCosmetic, () -> {
            cosmetics.remove(0);
            cosmetics.add(getRandomCosmetic());
            setCosmetic(inventory, cosmetics);
            new HSound(Sound.CLICK).playFor(cosmeticPlayer.getPlayer());
            if (pos + 1 >= DELAYS.length) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(hyperiorCosmetic, () -> {
                    new HSound(Sound.LEVEL_UP).playFor(cosmeticPlayer.getPlayer());
                    Cosmetic cosmetic = cosmetics.get(4);
                    cosmeticPlayer.getPlayer().sendMessage(HyperiorCosmetic.PREFIX + "§aDein Gewinn: " + cosmetic.getRarity().getColor() + cosmetic.getName());
                    Rarity rarity = cosmetic.getRarity();
                    for (int i = 9; i < 36; i++) {
                        if (i != 22) {
                            putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, rarity.getSubId()).setName(rarity.getColor() + rarity.getName()).build(), i, null);
                        }
                    }
                }, 10);
            } else {
                nextTick(cosmeticPlayer, inventory, cosmetics, pos + 1);
            }
        }, DELAYS[pos]);
    }

    private void setCosmetic(final Inventory inventory, final List<Cosmetic> cosmetics) {
        if (cosmetics.size() <= 9) {
            int column = 0;
            for (Cosmetic cosmetic : cosmetics) {
                Rarity rarity = cosmetic.getRarity();
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, rarity.getSubId()).setName(rarity.getColor() + rarity.getName()).build(), column + 9, null);
                ItemStack itemStack = cosmetic.getInventoryItem().clone();
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(rarity.getColor() + "§l" + cosmetic.getName());
                itemStack.setItemMeta(itemMeta);
                putItem(inventory, itemStack, column + 18, null);
                putItem(inventory, new ItemBuilder(Material.STAINED_GLASS_PANE, rarity.getSubId()).setName(rarity.getColor() + rarity.getName()).build(), column + 27, null);
                column++;
            }
        }
    }

    private Cosmetic getRandomCosmetic() {
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
