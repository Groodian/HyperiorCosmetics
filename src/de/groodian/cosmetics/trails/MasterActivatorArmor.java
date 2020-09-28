package de.groodian.cosmetics.trails;

import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.mysql.ActivatedCosmetics;
import de.groodian.cosmetics.mysql.Cosmetics;
import de.groodian.hyperiorcore.coinsystem.CoinSystem;
import de.groodian.hyperiorcore.ranks.Ranks;

public class MasterActivatorArmor {

	public static void run(Player player, String name, String databaseName, String type, int price) {
		if (Main.getIsEnabled()) {
			if (Cosmetics.has(player, databaseName)) {
				if (type.equals("helmet")) {
					if (Main.helmet.containsKey(player)) {
						if (Main.helmet.get(player).equals(name)) {
							player.sendMessage(Main.PREFIX + Main.helmet.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setHelmet(null);
							Main.helmet.remove(player);
							ActivatedCosmetics.deactivate(player, "helmet");
						} else {
							player.sendMessage(Main.PREFIX + Main.helmet.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setHelmet(null);
							Main.helmet.put(player, name);
							ActivatedCosmetics.activate(player, "helmet", name);
							player.sendMessage(Main.PREFIX + Main.helmet.get(player) + "§a wurde aktiviert!");
						}
					} else {
						Main.helmet.put(player, name);
						ActivatedCosmetics.activate(player, "helmet", name);
						player.sendMessage(Main.PREFIX + Main.helmet.get(player) + "§a wurde aktiviert!");
					}
				}
				if (type.equals("chestplate")) {
					if (Main.chestplate.containsKey(player)) {
						if (Main.chestplate.get(player).equals(name)) {
							player.sendMessage(Main.PREFIX + Main.chestplate.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setChestplate(null);
							Main.chestplate.remove(player);
							ActivatedCosmetics.deactivate(player, "chestplate");
						} else {
							player.sendMessage(Main.PREFIX + Main.chestplate.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setChestplate(null);
							Main.chestplate.put(player, name);
							ActivatedCosmetics.activate(player, "chestplate", name);
							player.sendMessage(Main.PREFIX + Main.chestplate.get(player) + "§a wurde aktiviert!");
						}
					} else {
						Main.chestplate.put(player, name);
						ActivatedCosmetics.activate(player, "chestplate", name);
						player.sendMessage(Main.PREFIX + Main.chestplate.get(player) + "§a wurde aktiviert!");
					}
				}
				if (type.equals("pants")) {
					if (Main.pants.containsKey(player)) {
						if (Main.pants.get(player).equals(name)) {
							player.sendMessage(Main.PREFIX + Main.pants.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setLeggings(null);
							Main.pants.remove(player);
							ActivatedCosmetics.deactivate(player, "pants");
						} else {
							player.sendMessage(Main.PREFIX + Main.pants.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setLeggings(null);
							Main.pants.put(player, name);
							ActivatedCosmetics.activate(player, "pants", name);
							player.sendMessage(Main.PREFIX + Main.pants.get(player) + "§a wurde aktiviert!");
						}
					} else {
						Main.pants.put(player, name);
						ActivatedCosmetics.activate(player, "pants", name);
						player.sendMessage(Main.PREFIX + Main.pants.get(player) + "§a wurde aktiviert!");
					}
				}
				if (type.equals("shoes")) {
					if (Main.shoes.containsKey(player)) {
						if (Main.shoes.get(player).equals(name)) {
							player.sendMessage(Main.PREFIX + Main.shoes.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setBoots(null);
							Main.shoes.remove(player);
							ActivatedCosmetics.deactivate(player, "shoes");
						} else {
							player.sendMessage(Main.PREFIX + Main.shoes.get(player) + "§c wurde deaktiviert!");
							player.getInventory().setBoots(null);
							Main.shoes.put(player, name);
							ActivatedCosmetics.activate(player, "shoes", name);
							player.sendMessage(Main.PREFIX + Main.shoes.get(player) + "§a wurde aktiviert!");
						}
					} else {
						Main.shoes.put(player, name);
						ActivatedCosmetics.activate(player, "shoes", name);
						player.sendMessage(Main.PREFIX + Main.shoes.get(player) + "§a wurde aktiviert!");
					}
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
