package de.groodian.cosmetics.trails;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.groodian.cosmetics.main.Main;

public class TrailsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			GUI.openGUI((Player) sender);
		} else {
			sender.sendMessage(Main.PREFIX + "Dieser Befehl muss von einem Spieler ausgeführt werden!");
		}
		return false;
	}

}
