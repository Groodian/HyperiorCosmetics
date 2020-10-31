package de.groodian.cosmetics;

import de.groodian.cosmetics.menu.CrateMenu;
import de.groodian.cosmetics.menu.MainMenu;
import de.groodian.cosmetics.player.CosmeticPlayerManager;
import de.groodian.cosmetics.test.TestCommand;
import de.groodian.hyperiorcore.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperiorCosmetic extends JavaPlugin {

    public static final String PREFIX = "§aCosmetics §7» ";
    public static final int COSMETIC_SLOT = 4;
    public static final int GADGET_SLOT = 8;
    public static final ItemStack COSMETIC_ITEM = new ItemBuilder(Material.CHEST).setName("§6§lKosmetik §7(Rechtsklick)").build();
    public static final ItemStack NO_GADGET_EQUIPPED_ITEM = new ItemBuilder(Material.FIREWORK_CHARGE).setName("§cKein Gadget ausgewählt!").build();

    private static HyperiorCosmetic instance;

    private long tick = 0;
    private boolean enabled = true;
    private CosmeticPlayerManager cosmeticPlayerManager;
    private MainMenu mainMenu;
    private CrateMenu crateMenu;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aDas Plugin wird geladen...");

        instance = this;

        CosmeticMySQL.init(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MainListener(this), this);

        getCommand("ctest").setExecutor(new TestCommand(this));

        cosmeticPlayerManager = new CosmeticPlayerManager();
        mainMenu = new MainMenu(this);
        crateMenu = new CrateMenu(this);

        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (enabled) cosmeticPlayerManager.updateAll(tick++);
        }, 40, 1);

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

    public CrateMenu getCrateMenu() {
        return crateMenu;
    }

    public static void openCrateMenu(Player player) {
        if (instance != null) {
            if (instance.crateMenu != null && instance.cosmeticPlayerManager != null) {
                instance.crateMenu.open(instance.cosmeticPlayerManager.getCosmeticPlayer(player));
            }
        }
    }

    public static void enable() {
        if (instance != null) {
            if (instance.cosmeticPlayerManager != null) {
                instance.cosmeticPlayerManager.resumeAll();
                instance.enabled = true;
            }
        }
    }

    public static void disable() {
        if (instance != null) {
            if (instance.cosmeticPlayerManager != null) {
                instance.cosmeticPlayerManager.pauseAll();
                instance.enabled = false;
            }
        }
    }

}
