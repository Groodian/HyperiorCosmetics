package de.groodian.cosmetics.test;

import de.groodian.cosmetics.Main;
import de.groodian.cosmetics.armor.ClassicArmor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private Main plugin;

    public TestCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        plugin.getCosmeticPlayerManager().getCosmeticPlayer((Player) sender).equip(ClassicArmor.valueOf(args[0]).getClassicArmor());

        return false;
    }
}
