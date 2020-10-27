package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

public class PortalParticleHandler extends ParticleHandler<DefaultCosmetic> {

    public PortalParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        Particle particle = new Particle(EnumParticle.PORTAL);
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
