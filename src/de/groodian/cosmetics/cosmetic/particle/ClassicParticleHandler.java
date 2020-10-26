package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;

public class ClassicParticleHandler extends CosmeticHandler<ClassicParticleCosmetic> {

    public ClassicParticleHandler(CosmeticPlayer cosmeticPlayer, ClassicParticleCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        cosmetic.getParticle().send(cosmeticPlayer.getPlayer().getLocation());
    }

    @Override
    public void onDisable() {
    }

}
