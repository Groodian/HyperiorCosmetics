package de.groodian.cosmetics;

import de.groodian.cosmetics.test.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static final String PREFIX = "§aCosmetics §7» ";

    private static Main instance;

    private CosmeticPlayerManager cosmeticPlayerManager;

    public void onEnable() {
        instance = this;

        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aDas Plugin wird geladen...");

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MainListener(this), this);

        getCommand("test").setExecutor(new TestCommand(this));

        this.cosmeticPlayerManager = new CosmeticPlayerManager();

        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aGeladen!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cDas Plugin wird gestoppt...");

        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cGestoppt!");
    }

    public static Main getInstance() {
        return instance;
    }

    public CosmeticPlayerManager getCosmeticPlayerManager() {
        return cosmeticPlayerManager;
    }

}
