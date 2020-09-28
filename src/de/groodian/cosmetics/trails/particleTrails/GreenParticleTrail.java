package de.groodian.cosmetics.trails.particleTrails;

import java.util.Map;

import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.Particle;
import de.groodian.cosmetics.trails.TrailsNames;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class GreenParticleTrail {

	public static void run() {
		for (Map.Entry<Player, String> current : Main.trail.entrySet()) {
			if (current.getValue().equals(TrailsNames.GREEN_PARTICLE_NAME)) {
				Particle particle0 = new Particle(EnumParticle.VILLAGER_HAPPY, current.getKey().getLocation().add(0, 0.5f, 0), true, 0, 0, 0, 0, 1, 0);
				particle0.sendAll();
			}
		}
	}
}
