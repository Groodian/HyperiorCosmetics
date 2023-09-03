package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Location;
import org.bukkit.Particle;

public class PortalParticleHandler extends ParticleHandler<DefaultCosmetic> {

    public PortalParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        HParticle particle = new HParticle(Particle.PORTAL);
        Location location = cosmeticPlayer.getPlayer().getLocation();
        for (int i = 0; i <= 360; i += 10) {
            double radiant = Math.toRadians(i);
            Location particleLocation = location.clone().add(Math.sin(radiant) * 0.7, 0.3, Math.cos(radiant) * 0.7);
            particle.send(particleLocation);
            particle.send(particleLocation.add(0, 0.7, 0));
        }
    }

    @Override
    public void onDisable() {
    }

}
