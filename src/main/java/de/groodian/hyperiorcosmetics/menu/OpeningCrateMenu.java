package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Rarity;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

public class OpeningCrateMenu extends GUI {

    private static final int[] DELAYS = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 10,
                                                  15, 15};

    private final HyperiorCosmetic hyperiorCosmetic;
    private final CosmeticPlayer cosmeticPlayer;
    private final Cosmetic win;
    private final boolean isOwningCosmetic;
    private final Random random;

    public OpeningCrateMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticPlayer cosmeticPlayer, Cosmetic win, boolean isOwningCosmetic) {
        super(Component.text("Öffne Kiste..."), 45);
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.cosmeticPlayer = cosmeticPlayer;
        this.win = win;
        this.isOwningCosmetic = isOwningCosmetic;
        this.random = new Random();
    }

    @Override
    protected void onOpen() {
        ItemStack yourWin = new ItemBuilder(Material.NETHER_STAR).setName(Component.text("Dein Gewinn:", NamedTextColor.GRAY)).build();
        putItem(yourWin, 4);
        putItem(yourWin, 40);

        List<Cosmetic> cosmetics = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cosmetics.add(Cosmetic.getRandomCosmetic(random));
        }
        setCosmetic(cosmetics);
        nextTick(cosmeticPlayer, cosmetics, 0);

        new HSound(Sound.ENTITY_PLAYER_LEVELUP).playFor(cosmeticPlayer.getPlayer());
    }

    private void nextTick(CosmeticPlayer cosmeticPlayer, List<Cosmetic> cosmetics, int pos) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(hyperiorCosmetic, () -> {
            cosmetics.remove(0);

            if (pos == DELAYS.length - 5) {
                cosmetics.add(win);
            } else {
                cosmetics.add(Cosmetic.getRandomCosmetic(random));
            }

            setCosmetic(cosmetics);
            new HSound(Sound.UI_BUTTON_CLICK).playFor(player);

            if (pos + 1 >= DELAYS.length) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(hyperiorCosmetic, () -> {
                    new HSound(Sound.ENTITY_PLAYER_LEVELUP).playFor(player);

                    Rarity rarity = win.getRarity();
                    for (int i = 9; i < 36; i++) {
                        if (i != 22) {
                            ItemStack rarityItem = new ItemBuilder(rarity.getMaterial())
                                    .setName(Component.text(rarity.getName(), rarity.getColor()))
                                    .build();
                            putItem(rarityItem, i);
                        }
                    }

                    if (isOwningCosmetic) {
                        ItemStack winItem = new ItemBuilder(win.getInventoryItem().clone()).addLore(
                                Component.empty(),
                                Component.text("Du besitzt diesen Gegenstand bereits!", NamedTextColor.RED),
                                Component.text("Dieser Gegenstand wurde automatisch", NamedTextColor.RED),
                                Component.text("für ", NamedTextColor.RED)
                                        .append(Component.text(win.getRarity().getSellPrice() + " Coins", NamedTextColor.YELLOW))
                                        .append(Component.text(" verkauft.", NamedTextColor.RED))).build();
                        putItem(winItem, 22);
                    } else {
                        player.sendMessage(HyperiorCosmetic.PREFIX
                                .append(Component.text("Dein Gewinn: ", NamedTextColor.GREEN))
                                .append(Component.text(win.getName(), rarity.getColor())));

                    }
                }, 10);
            } else {
                nextTick(cosmeticPlayer, cosmetics, pos + 1);
            }

        }, DELAYS[pos]);
    }

    private void setCosmetic(List<Cosmetic> cosmetics) {
        if (cosmetics.size() <= 9) {
            int column = 0;
            for (Cosmetic cosmetic : cosmetics) {
                Rarity rarity = cosmetic.getRarity();
                ItemStack rarityItem = new ItemBuilder(rarity.getMaterial())
                        .setName(Component.text(rarity.getName(), rarity.getColor()))
                        .build();
                putItem(rarityItem, column + 9);
                putItem(cosmetic.getInventoryItem(), column + 18);
                putItem(rarityItem, column + 27);
                column++;
            }
        }
    }

    @Override
    public void onUpdate() {
    }

}
