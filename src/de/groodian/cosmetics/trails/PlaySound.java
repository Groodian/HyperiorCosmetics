package de.groodian.cosmetics.trails;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound {

	public void playSound(Sound sound) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), sound, 1, 1);
		}
	}

	public void playSoundFor(Sound sound, Player player) {
		player.playSound(player.getLocation(), sound, 1, 1);
	}

}

