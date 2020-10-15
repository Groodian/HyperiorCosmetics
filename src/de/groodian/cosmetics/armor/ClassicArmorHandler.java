package de.groodian.cosmetics.armor;

import de.groodian.cosmetics.CosmeticHandler;
import de.groodian.cosmetics.CosmeticPlayer;

public class ClassicArmorHandler extends CosmeticHandler<ClassicArmorCosmetic> {

    public ClassicArmorHandler(CosmeticPlayer cosmeticPlayer, ClassicArmorCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
        switch (cosmetic.getCategory()) {
            case HELMET:
                cosmeticPlayer.getPlayer().getInventory().setHelmet(cosmetic.getEquipItem());
                break;
            case CHEST_PLATE:
                cosmeticPlayer.getPlayer().getInventory().setChestplate(cosmetic.getEquipItem());
                break;
            case PANTS:
                cosmeticPlayer.getPlayer().getInventory().setLeggings(cosmetic.getEquipItem());
                break;
            case SHOES:
                cosmeticPlayer.getPlayer().getInventory().setBoots(cosmetic.getEquipItem());
                break;
        }
    }

    @Override
    public void onUpdate() {
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
