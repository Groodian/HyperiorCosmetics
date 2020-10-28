package de.groodian.cosmetics;

import de.groodian.cosmetics.menu.MainMenu;
import de.groodian.cosmetics.player.CosmeticPlayerManager;
import de.groodian.cosmetics.test.TestCommand;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperiorCosmetic extends JavaPlugin {

    public static final String PREFIX = "�aCosmetics �7� ";
    public static final int COSMETIC_SLOT = 4;
    public static final int GADGET_SLOT = 8;
    public static final ItemStack COSMETIC_ITEM = new ItemBuilder(Material.CHEST).setName("�6�lKosmetik �7(Rechtsklick)").build();
    public static final ItemStack NO_GADGET_EQUIPPED_ITEM = new ItemBuilder(Material.FIREWORK_CHARGE).setName("�cKein Gadget ausgew�hlt!").build();

    private long tick = 0;
    private CosmeticPlayerManager cosmeticPlayerManager;
    private MainMenu mainMenu;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "�aDas Plugin wird geladen...");

        CosmeticMySQL.init(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MainListener(this), this);

        getCommand("ctest").setExecutor(new TestCommand(this));

        cosmeticPlayerManager = new CosmeticPlayerManager();
        mainMenu = new MainMenu(this);

        Bukkit.getScheduler().runTaskTimer(this, () -> cosmeticPlayerManager.updateAll(tick++), 40, 1);

        Bukkit.getConsoleSender().sendMessage(PREFIX + "�aGeladen!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "�cDas Plugin wird gestoppt...");

        Bukkit.getConsoleSender().sendMessage(PREFIX + "�cGestoppt!");
    }

    public CosmeticPlayerManager getCosmeticPlayerManager() {
        return cosmeticPlayerManager;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

}
