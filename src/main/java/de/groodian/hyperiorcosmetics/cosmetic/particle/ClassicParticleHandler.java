package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

public class ClassicParticleHandler extends ParticleHandler<ClassicParticleCosmetic> {

    public ClassicParticleHandler(CosmeticPlayer cosmeticPlayer, ClassicParticleCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        cosmetic.getParticle().send(cosmeticPlayer.getPlayer().getLocation().add(0, 0.3, 0));
    }

    @Override
    public void onDisable() {
    }

}
