package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Location;
import org.bukkit.Particle;

public class RingParticleHandler extends ParticleHandler<DefaultCosmetic> {

    private int degree = 0;

    public RingParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        HParticle particle = new HParticle(Particle.FLAME, 0, null);
        Location location = cosmeticPlayer.getPlayer().getLocation();
        double radiant = Math.toRadians(degree);
        Location particleLocation0 = location.clone().add(Math.sin(radiant) * 0.8, Math.sin(radiant) + 1, Math.cos(radiant) * 0.8);
        Location particleLocation1 = location.clone().add(Math.cos(radiant) * 0.8, -Math.cos(radiant) + 1, Math.sin(radiant) * 0.8);
        particle.send(rotateAroundYAxis(location, particleLocation0, location.getYaw()));
        particle.send(rotateAroundYAxis(location, particleLocation1, location.getYaw()));
        degree += 10;
        if (degree > 360) {
            degree = 0;
        }
    }

    @Override
    public void onDisable() {
    }

}
