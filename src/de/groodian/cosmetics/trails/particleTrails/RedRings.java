package de.groodian.cosmetics.trails.particleTrails;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RedRings {

    public static ArrayList<Player> toRemove = new ArrayList<Player>();

    private static HashMap<Player, Float> radius = new HashMap<Player, Float>();
    private static HashMap<Player, Float> height = new HashMap<Player, Float>();
    private static HashMap<Player, Integer> count = new HashMap<Player, Integer>();

    public static void run() {
        for (Player remove : toRemove) {
            radius.remove(remove);
            height.remove(remove);
            count.remove(remove);
        }
        toRemove.clear();
        for (Map.Entry<Player, String> current : Main.trail.entrySet()) {
            if (current.getValue().equals(TrailsNames.REDRINGS_NAME)) {
                if (!radius.containsKey(current.getKey())) {
                    radius.put(current.getKey(), 0.15f);
                    height.put(current.getKey(), 2.5f);
                    count.put(current.getKey(), 1);
                } else {
                    radius.put(current.getKey(), radius.get(current.getKey()) + 0.15f);
                    height.put(current.getKey(), height.get(current.getKey()) - 0.3f);
                    count.put(current.getKey(), count.get(current.getKey()) + 1);
                    if (count.get(current.getKey()) >= 10) {
                        radius.put(current.getKey(), 0.15f);
                        height.put(current.getKey(), 2.5f);
                        count.put(current.getKey(), 1);
                    }
                }
                for (float t = 0; t <= 25; t++) {

                    float x = radius.get(current.getKey()) * (float) Math.sin(t);
                    float z = radius.get(current.getKey()) * (float) Math.cos(t);
                    float y = height.get(current.getKey());
                    Particle particle0 = new Particle(EnumParticle.REDSTONE, current.getKey().getLocation().add(x, y, z), true, 0, 0, 0, 0, 1, 0);
                    particle0.sendAll();
                }
            }
        }
    }
}
