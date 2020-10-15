package de.groodian.cosmetics.test;

import de.groodian.cosmetics.Category;
import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.Main;
import de.groodian.cosmetics.armor.ClassicArmor;
import de.groodian.cosmetics.armor.ClassicArmorCosmetic;
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

        if (args.length == 2) {

            Player player = (Player) sender;
            CosmeticPlayer cosmeticPlayer = plugin.getCosmeticPlayerManager().getCosmeticPlayer(player);
            if (args[0].equalsIgnoreCase("equip")) {
                ClassicArmorCosmetic classicArmor = ClassicArmor.valueOf(args[1]).getClassicArmor();
                cosmeticPlayer.equip(classicArmor);
            } else if (args[0].equalsIgnoreCase("disable")) {
                Category category = Category.valueOf(args[1]);
                cosmeticPlayer.disableCosmetic(category);
            }

        } else {
            sender.sendMessage("Fehler!");
        }

        return false;
    }
}
