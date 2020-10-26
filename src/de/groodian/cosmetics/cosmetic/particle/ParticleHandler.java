package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;

public class ParticleHandler extends CosmeticHandler<ParticleCosmetic> {

    public ParticleHandler(CosmeticPlayer cosmeticPlayer, ParticleCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        new Particle(cosmetic.getParticleType(), cosmeticPlayer.getPlayer().getLocation().add(0, 0.35, 0), false, 0, 0, 0, 0, 0, 0).sendAll();
    }

    @Override
    public void onDisable() {
    }

}
