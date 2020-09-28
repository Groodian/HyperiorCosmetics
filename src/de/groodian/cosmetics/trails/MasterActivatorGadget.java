package de.groodian.cosmetics.trails;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.mysql.ActivatedCosmetics;
import de.groodian.cosmetics.mysql.Cosmetics;
import de.groodian.hyperiorcore.coinsystem.CoinSystem;
import de.groodian.hyperiorcore.ranks.Ranks;

public class MasterActivatorGadget {

	public static void run(Player player, String name, String databaseName, int price) {
		if (Main.getIsEnabled()) {
			if (Cosmetics.has(player, databaseName)) {
				if (Main.gadget.containsKey(player)) {
					if (Main.gadget.get(player).equals(name)) {
						player.sendMessage(Main.PREFIX + Main.gadget.get(player) + "�c wurde deaktiviert!");
						Main.gadget.remove(player);
						ActivatedCosmetics.deactivate(player, "gadget");
						player.getInventory().setItem(7, new ItemBuilder(Material.FIREWORK_CHARGE).setName("�cKein Gadget ausgew�hlt!").build());
					} else {
						player.sendMessage(Main.PREFIX + Main.gadget.get(player) + "�c wurde deaktiviert!");
						Main.gadget.put(player, name);
						ActivatedCosmetics.activate(player, "gadget", name);
						player.sendMessage(Main.PREFIX + Main.gadget.get(player) + "�a wurde aktiviert!");
					}
				} else {
					Main.gadget.put(player, name);
					ActivatedCosmetics.activate(player, "gadget", name);
					player.sendMessage(Main.PREFIX + Main.gadget.get(player) + "�a wurde aktiviert!");
				}
			} else {
				if (Ranks.has(player.getUniqueId().toString().replaceAll("-", ""), "cosmetics.all")) {
					long tempCoins = CoinSystem.getCoins(player);
					if (tempCoins >= price) {
						CoinSystem.removeCoins(player, price, false);
						Cosmetics.add(player, databaseName);
						player.sendMessage(Main.PREFIX + "�aDu hast dir erfolgreich den Gegenstand: " + name + "�a f�r �e" + price + " �6Coins �agekauft.");
					} else {
						player.sendMessage(Main.PREFIX + "�cDir fehlen noch �e" + (price - tempCoins) + " �6Coins �cum diesen Gegenstand zu Kaufen.");
					}
				} else {
					player.sendMessage(Main.PREFIX + "�cDu ben�tigst den Gr�nder-Rang um Gegenst�nde zu Kaufen.");
				}
			}
		} else {
			player.sendMessage(Main.PREFIX + "�cKann nicht w�hrend der Runde verwendet werden.");
		}
	}

}
