package de.groodian.cosmetics.trails.blockTrails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;

public class WheatBlockTrail {

	public static ArrayList<Player> toRemove = new ArrayList<Player>();

	private static HashMap<Player, Integer> nextCrops = new HashMap<Player, Integer>();

	@SuppressWarnings("deprecation")
	public static void run() {
		for (Player remove : toRemove) {
			nextCrops.remove(remove);
		}
		toRemove.clear();
		for (Map.Entry<Player, String> current : Main.trail.entrySet()) {
			if (current.getValue().equals(TrailsNames.WHEAT_TRAIL_NAME)) {
				if (current.getKey().getLocation().getBlock().getType() == Material.AIR) {
					if (current.getKey().isOnGround()) {
						if (current.getKey().getLocation().add(0, -1, 0).getBlock().getType() != Material.AIR) {
							BlockTrailsClear.blocks.put(current.getKey().getLocation().getBlock(), BlockTrailsClear.liveTime);
							if (!nextCrops.containsKey(current.getKey())) {
								nextCrops.put(current.getKey(), 0);
							} else {
								nextCrops.put(current.getKey(), nextCrops.get(current.getKey()) + 1);
								if (nextCrops.get(current.getKey()) >= 8) {
									nextCrops.put(current.getKey(), 0);
								}
							}
							for (Player all : Bukkit.getOnlinePlayers()) {
								if ((current.getKey().getWorld() == all.getWorld()) && (all.getLocation().distance(current.getKey().getLocation()) <= BlockTrailsClear.distance)) {
									Integer i = nextCrops.get(current.getKey());
									all.sendBlockChange(current.getKey().getLocation(), Material.CROPS, (byte) i.intValue());
								}
							}
						}
					}
				}
			}
		}
	}
}
