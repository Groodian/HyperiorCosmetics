package de.groodian.cosmetics;

import de.groodian.cosmetics.menu.MainMenu;
import de.groodian.cosmetics.test.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperiorCosmetic extends JavaPlugin {

    public static final String PREFIX = "§aCosmetics §7» ";

    private CosmeticPlayerManager cosmeticPlayerManager;
    private MainMenu mainMenu;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aDas Plugin wird geladen...");

        CosmeticMySQL.init(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MainListener(this), this);

        getCommand("ctest").setExecutor(new TestCommand(this));

        cosmeticPlayerManager = new CosmeticPlayerManager();
        mainMenu = new MainMenu(this);

        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aGeladen!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cDas Plugin wird gestoppt...");

        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cGestoppt!");
    }

    public CosmeticPlayerManager getCosmeticPlayerManager() {
        return cosmeticPlayerManager;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

}
