package de.groodian.cosmetics.trails;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.mysql.ActivatedCosmetics;

public class MainListener implements Listener {

	@EventHandler
	public void handlePlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (Main.trail.containsKey(player))
			Main.trail.remove(player);
		if (Main.helmet.containsKey(player))
			Main.helmet.remove(player);
		if (Main.chestplate.containsKey(player))
			Main.chestplate.remove(player);
		if (Main.pants.containsKey(player))
			Main.pants.remove(player);
		if (Main.shoes.containsKey(player))
			Main.shoes.remove(player);
	}
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "trail")) != null)
			Main.trail.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "trail"));
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "helmet")) != null)
			Main.helmet.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "helmet"));
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "chestplate")) != null)
			Main.chestplate.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "chestplate"));
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "pants")) != null)
			Main.pants.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "pants"));
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "shoes")) != null)
			Main.shoes.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "shoes"));
		if((ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "gadget")) != null)
			Main.gadget.put(player, ActivatedCosmetics.get(player.getUniqueId().toString().replaceAll("-", ""), "gadget"));
			
	}

}
