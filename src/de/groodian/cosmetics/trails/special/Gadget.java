package de.groodian.cosmetics.trails.special;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.ItemBuilder;
import de.groodian.cosmetics.trails.TrailsNames;

public class Gadget {

	public static void run() {
		for (Map.Entry<Player, String> current : Main.gadget.entrySet()) {
			if (current.getValue().equals(TrailsNames.FLIGHT_STICK_NAME))
				current.getKey().getInventory().setItem(7, new ItemBuilder(Material.BLAZE_ROD).setName(TrailsNames.FLIGHT_STICK_NAME + " §7(Rechtsklick)").setLore("§7Seltenheit: §cSchwarzmarktware").build());
			if (current.getValue().equals(TrailsNames.FIREWORK_NAME))
				current.getKey().getInventory().setItem(7, new ItemBuilder(Material.FIREWORK).setName(TrailsNames.FIREWORK_NAME + " §7(Rechtsklick)").setLore("§7Seltenheit: §6Mystisch").build());
		}
	}

}
