package de.groodian.cosmetics.trails;

import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.mysql.ActivatedCosmetics;
import de.groodian.cosmetics.mysql.Cosmetics;
import de.groodian.hyperiorcore.coinsystem.CoinSystem;
import de.groodian.hyperiorcore.ranks.Ranks;

public class MasterActivatorTrails {

	public static void run(Player player, String name, String databaseName, int price) {
		if (Main.getIsEnabled()) {
			if (Cosmetics.has(player, databaseName)) {
				if (Main.trail.containsKey(player)) {
					if (Main.trail.get(player).equals(name)) {
						player.sendMessage(Main.PREFIX + Main.trail.get(player) + "§c wurde deaktiviert!");
						Main.trail.remove(player);
						ActivatedCosmetics.deactivate(player, "trail");
					} else {
						player.sendMessage(Main.PREFIX + Main.trail.get(player) + "§c wurde deaktiviert!");
						Main.trail.put(player, name);
						ActivatedCosmetics.activate(player, "trail", name);
						player.sendMessage(Main.PREFIX + Main.trail.get(player) + "§a wurde aktiviert!");
					}
				} else {
					Main.trail.put(player, name);
					ActivatedCosmetics.activate(player, "trail", name);
					player.sendMessage(Main.PREFIX + Main.trail.get(player) + "§a wurde aktiviert!");
				}
			} else {
				if (Ranks.has(player.getUniqueId().toString().replaceAll("-", ""), "cosmetics.all")) {
					long tempCoins = CoinSystem.getCoins(player);
					if (tempCoins >= price) {
						CoinSystem.removeCoins(player, price, false);
						Cosmetics.add(player, databaseName);
						player.sendMessage(Main.PREFIX + "§aDu hast dir erfolgreich den Gegenstand: " + name + "§a für §e" + price + " §6Coins §agekauft.");
					} else {
						player.sendMessage(Main.PREFIX + "§cDir fehlen noch §e" + (price - tempCoins) + " §6Coins §cum diesen Gegenstand zu Kaufen.");
					}
				} else {
					player.sendMessage(Main.PREFIX + "§cDu benötigst den Gründer-Rang um Gegenstände zu Kaufen.");
				}
			}
		} else {
			player.sendMessage(Main.PREFIX + "§cKann nicht während der Runde verwendet werden.");
		}
	}

}
