package de.groodian.cosmetics.trails.blockTrails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BlockTrailsClear {

	public static HashMap<Block, Integer> blocks = new HashMap<Block, Integer>();
	public static int liveTime = 10;
	public static int distance = 20;

	@SuppressWarnings("deprecation")
	public static void run() {
		if (!blocks.isEmpty()) {
			ArrayList<Block> blocksToRemove = new ArrayList<>();
			for (Map.Entry<Block, Integer> entry : blocks.entrySet()) {
				Block key = entry.getKey();
				Integer value = entry.getValue();
				for (Player proCheck : Bukkit.getOnlinePlayers()) {
					if ((key.getWorld() == proCheck.getWorld()) && (proCheck.getLocation().distance(key.getLocation()) > distance) && (proCheck.getLocation().distance(key.getLocation()) < distance + 25)) {
						proCheck.sendBlockChange(key.getLocation(), key.getType(), key.getData());
					}
				}
				if (value.intValue() <= 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						if ((key.getWorld() == all.getWorld()) && (all.getLocation().distance(key.getLocation()) <= distance)) {
							all.sendBlockChange(key.getLocation(), key.getType(), key.getData());
							blocksToRemove.add(key);
						}
					}
				} else {
					blocks.put(key, value.intValue() - 1);
				}
			}
			for (Block block : blocksToRemove) {
				blocks.remove(block);
			}
		}
	}

}
