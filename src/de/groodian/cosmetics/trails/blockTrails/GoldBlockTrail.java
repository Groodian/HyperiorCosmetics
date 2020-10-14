package de.groodian.cosmetics.trails.blockTrails;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import java.util.Map;

public class GoldBlockTrail {

    @SuppressWarnings("deprecation")
    public static void run() {
        for (Map.Entry<Player, String> current : Main.trail.entrySet()) {
            if (current.getValue().equals(TrailsNames.GOLD_BLOCK_TRAIL_NAME)) {
                if (current.getKey().getLocation().add(0, -1, 0).getBlock().getType() != Material.AIR) {
                    if (current.getKey().getLocation().add(0, -1, 0).getBlock().getType() != Material.LONG_GRASS) {
                        if (!(current.getKey().getLocation().add(0, -1, 0).getBlock().getState() instanceof Sign)) {
                            BlockTrailsClear.blocks.put(current.getKey().getLocation().add(0, -1, 0).getBlock(), BlockTrailsClear.liveTime);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                if ((current.getKey().getWorld() == all.getWorld()) && (all.getLocation().distance(current.getKey().getLocation()) <= BlockTrailsClear.distance)) {
                                    all.sendBlockChange(current.getKey().getLocation().add(0, -1, 0), Material.GOLD_BLOCK, (byte) 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
