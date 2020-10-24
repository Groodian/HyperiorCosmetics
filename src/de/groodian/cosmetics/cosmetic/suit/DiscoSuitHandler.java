package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DiscoSuitHandler extends CosmeticHandler<DefaultCosmetic> {

    private Random random;

    public DiscoSuitHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
        random = new Random();
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        ItemStack itemStack = new ItemBuilder(Material.LEATHER_HELMET).setName(cosmetic.getRarity().getColor() + cosmetic.getName()).setColorAndBuild(random.nextInt(255), random.nextInt(255), random.nextInt(255));
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

}
