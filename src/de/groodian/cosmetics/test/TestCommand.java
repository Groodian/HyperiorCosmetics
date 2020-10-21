package de.groodian.cosmetics.test;

import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private HyperiorCosmetic plugin;

    public TestCommand(HyperiorCosmetic plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        CosmeticPlayer cosmeticPlayer = plugin.getCosmeticPlayerManager().getCosmeticPlayer(player);

        if (args.length == 0) {
            plugin.getMainMenu().open(cosmeticPlayer);
            return false;
        } else {
            sender.sendMessage("Fehler!");
        }

        return false;
    }
}
