package de.groodian.cosmetics.trails.particleTrails;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.entity.Player;

import java.util.Map;

public class RainbowDustTrail {

    public static void run() {
        for (Map.Entry<Player, String> current : Main.trail.entrySet()) {
            if (current.getValue().equals(TrailsNames.RAINBOW_PARTICLE_NAME)) {
                Particle particle0 = new Particle(EnumParticle.REDSTONE, current.getKey().getLocation().add(0, 0.15f, 0), true, 0, 0, 0, 1, 1, 0);
                Particle particle1 = new Particle(EnumParticle.REDSTONE, current.getKey().getLocation().add(0, 0.30f, 0), true, 0, 0, 0, 1, 1, 0);
                Particle particle2 = new Particle(EnumParticle.REDSTONE, current.getKey().getLocation().add(0, 0.45f, 0), true, 0, 0, 0, 1, 1, 0);
                Particle particle3 = new Particle(EnumParticle.REDSTONE, current.getKey().getLocation().add(0, 0.60f, 0), true, 0, 0, 0, 1, 1, 0);
                particle0.sendAll();
                particle1.sendAll();
                particle2.sendAll();
                particle3.sendAll();
            }
        }
    }
}
