package de.groodian.hyperiorcosmetics.cosmetic.suit;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RainbowSuitHandler extends CosmeticHandler<DefaultCosmetic> {

    private static final int SPEED = 15;

    private boolean isMaster = true;

    private int red = 255;
    private int green = 0;
    private int blue = 0;

    public RainbowSuitHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);

        for (CosmeticHandler<?> cosmeticHandler : cosmeticPlayer.getHandlers()) {
            if (cosmeticHandler instanceof RainbowSuitHandler) {
                isMaster = false;
                break;
            }
        }
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        if (isMaster) {
            for (int i = 0; i < SPEED; i++) {
                if (red > 0 && blue == 0) {
                    red--;
                    green++;
                }
                if (green > 0 && red == 0) {
                    green--;
                    blue++;
                }
                if (blue > 0 && green == 0) {
                    red++;
                    blue--;
                }
            }
        } else {
            boolean foundMaster = false;
            for (CosmeticHandler<?> cosmeticHandler : cosmeticPlayer.getHandlers()) {
                if (cosmeticHandler instanceof RainbowSuitHandler rainbowSuitHandler) {
                    if (rainbowSuitHandler.isMaster()) {
                        red = rainbowSuitHandler.getRed();
                        green = rainbowSuitHandler.getGreen();
                        blue = rainbowSuitHandler.getBlue();
                        foundMaster = true;
                        break;
                    }
                }
            }
            if (!foundMaster) {
                for (CosmeticHandler<?> cosmeticHandler : cosmeticPlayer.getHandlers()) {
                    if (cosmeticHandler instanceof RainbowSuitHandler rainbowSuitHandler) {
                        rainbowSuitHandler.newMaster();
                        break;
                    }
                }
            }
        }

        ItemStack itemStack = new ItemBuilder(Material.LEATHER_HELMET)
                .setName(cosmetic.getInventoryItem().getItemMeta().displayName())
                .setLore(cosmetic.getInventoryItem().getItemMeta().lore())
                .setLeatherColor(red, green, blue)
                .build();

        switch (cosmetic.getCategory()) {
            case HELMET -> {
                itemStack.setType(Material.LEATHER_HELMET);
                cosmeticPlayer.getPlayer().getInventory().setHelmet(itemStack);
            }
            case CHEST_PLATE -> {
                itemStack.setType(Material.LEATHER_CHESTPLATE);
                cosmeticPlayer.getPlayer().getInventory().setChestplate(itemStack);
            }
            case PANTS -> {
                itemStack.setType(Material.LEATHER_LEGGINGS);
                cosmeticPlayer.getPlayer().getInventory().setLeggings(itemStack);
            }
            case SHOES -> {
                itemStack.setType(Material.LEATHER_BOOTS);
                cosmeticPlayer.getPlayer().getInventory().setBoots(itemStack);
            }
        }

    }

    @Override
    public void onDisable() {
        switch (cosmetic.getCategory()) {
            case HELMET -> cosmeticPlayer.getPlayer().getInventory().setHelmet(null);
            case CHEST_PLATE -> cosmeticPlayer.getPlayer().getInventory().setChestplate(null);
            case PANTS -> cosmeticPlayer.getPlayer().getInventory().setLeggings(null);
            case SHOES -> cosmeticPlayer.getPlayer().getInventory().setBoots(null);
        }
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void newMaster() {
        isMaster = true;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

}
