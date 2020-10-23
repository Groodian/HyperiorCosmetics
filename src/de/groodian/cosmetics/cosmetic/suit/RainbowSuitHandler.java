package de.groodian.cosmetics.cosmetic.suit;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;

public class RainbowSuitHandler extends CosmeticHandler<AdvancedSuitCosmetic> {

    public RainbowSuitHandler(CosmeticPlayer cosmeticPlayer, AdvancedSuitCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        for(CosmeticHandler<?> cosmeticHandler : cosmeticPlayer.getHandlers()) {
            if(cosmeticHandler instanceof  RainbowSuitHandler) {

            }
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
