package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RainbowSuitHandler extends CosmeticHandler<AdvancedSuitCosmetic> {

    private static final int SPEED = 20;

    private boolean isMaster = true;

    private int red = 255;
    private int green = 0;
    private int blue = 0;

    public RainbowSuitHandler(CosmeticPlayer cosmeticPlayer, AdvancedSuitCosmetic cosmetic) {
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
                if (cosmeticHandler instanceof RainbowSuitHandler) {
                    RainbowSuitHandler rainbowSuitHandler = (RainbowSuitHandler) cosmeticHandler;
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
                    if (cosmeticHandler instanceof RainbowSuitHandler) {
                        ((RainbowSuitHandler) cosmeticHandler).newMaster();
                        Bukkit.broadcastMessage("New MAster!!!!!");
                        break;
                    }
                }
            }
        }

        ItemStack itemStack = new ItemBuilder(Material.LEATHER_HELMET).setName(cosmetic.getRarity().getColor() + cosmetic.getName()).setColorAndBuild(red, green, blue);
        switch (cosmetic.getCategory()) {
            case HELMET:
                itemStack.setType(Material.LEATHER_HELMET);
                cosmeticPlayer.getPlayer().getInventory().setHelmet(itemStack);
                break;
            case CHEST_PLATE:
                itemStack.setType(Material.LEATHER_CHESTPLATE);
                cosmeticPlayer.getPlayer().getInventory().setChestplate(itemStack);
                break;
            case PANTS:
                itemStack.setType(Material.LEATHER_LEGGINGS);
                cosmeticPlayer.getPlayer().getInventory().setLeggings(itemStack);
                break;
            case SHOES:
                itemStack.setType(Material.LEATHER_BOOTS);
                cosmeticPlayer.getPlayer().getInventory().setBoots(itemStack);
                break;
        }

    }

    @Override
    public void onDisable() {
        switch (cosmetic.getCategory()) {
            case HELMET:
                cosmeticPlayer.getPlayer().getInventory().setHelmet(null);
                break;
            case CHEST_PLATE:
                cosmeticPlayer.getPlayer().getInventory().setChestplate(null);
                break;
            case PANTS:
                cosmeticPlayer.getPlayer().getInventory().setLeggings(null);
                break;
            case SHOES:
                cosmeticPlayer.getPlayer().getInventory().setBoots(null);
                break;
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
