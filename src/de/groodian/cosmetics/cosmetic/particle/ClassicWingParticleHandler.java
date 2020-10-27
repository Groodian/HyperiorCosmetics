package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.player.CosmeticPlayer;

public class ClassicWingParticleHandler extends WingParticleHandler<WingParticleCosmetic> {

    public ClassicWingParticleHandler(CosmeticPlayer cosmeticPlayer, WingParticleCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        setWing(cosmetic.getParticle());
    }

    @Override
    public void onDisable() {
    }

}
