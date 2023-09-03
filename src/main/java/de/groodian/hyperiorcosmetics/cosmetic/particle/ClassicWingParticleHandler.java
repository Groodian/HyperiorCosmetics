package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

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
