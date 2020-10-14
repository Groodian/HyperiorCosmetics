package de.groodian.cosmetics.main;

import de.groodian.cosmetics.CosmeticPlayerManager;
import de.groodian.cosmetics.trails.GUI;
import de.groodian.cosmetics.trails.GUIListener;
import de.groodian.cosmetics.trails.MainListener;
import de.groodian.cosmetics.trails.armor.ClassicArmor;
import de.groodian.cosmetics.trails.armor.RainbowArmor;
import de.groodian.cosmetics.trails.blockTrails.BlockTrailsClear;
import de.groodian.cosmetics.trails.blockTrails.GoldBlockTrail;
import de.groodian.cosmetics.trails.blockTrails.RainbowClayTrail;
import de.groodian.cosmetics.trails.blockTrails.RainbowGlassTrail;
import de.groodian.cosmetics.trails.blockTrails.RainbowWoolTrail;
import de.groodian.cosmetics.trails.blockTrails.WheatBlockTrail;
import de.groodian.cosmetics.trails.particleTrails.BlazeParticleTrail;
import de.groodian.cosmetics.trails.particleTrails.FlameParticleTrail;
import de.groodian.cosmetics.trails.particleTrails.GreenParticleTrail;
import de.groodian.cosmetics.trails.particleTrails.LavaParticleTrail;
import de.groodian.cosmetics.trails.particleTrails.RainbowDustTrail;
import de.groodian.cosmetics.trails.particleTrails.RedRings;
import de.groodian.cosmetics.trails.particleTrails.WaterParticleTrail;
import de.groodian.cosmetics.trails.special.Firework;
import de.groodian.cosmetics.trails.special.FlightStick;
import de.groodian.cosmetics.trails.special.Gadget;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    private static Main instance;

    public static final String PREFIX = "§aTrails §7» ";

    public static final HashMap<Player, String> trail = new HashMap<Player, String>();
    public static final HashMap<Player, String> gadget = new HashMap<Player, String>();
    public static final HashMap<Player, String> helmet = new HashMap<Player, String>();
    public static final HashMap<Player, String> chestplate = new HashMap<Player, String>();
    public static final HashMap<Player, String> pants = new HashMap<Player, String>();
    public static final HashMap<Player, String> shoes = new HashMap<Player, String>();
    private static boolean isEnabled;

    private PlaySound playSound;
    public static GUI gui;

    private CosmeticPlayerManager cosmeticPlayerManager;

    public void onEnable() {
        instance = this;
        isEnabled = true;
        playSound = new PlaySound();
        gui = new GUI(this);

        // console
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aDas Plugin wird geladen...");

        MySQLCosmetics.connect();

        // commands
        getCommand("cosmetics").setExecutor(new TrailsCommands());

        // events
        registerEvents();

        // repeat 40ticks
        BukkitRunnable bukkitRunnableVerySlow = new BukkitRunnable() {
            @Override
            public void run() {
                if (!isEnabled)
                    return;
                ClassicArmor.run();
                Gadget.run();
            }
        };
        bukkitRunnableVerySlow.runTaskTimer(plugin, 0, 40);

        // repeat 5ticks
        BukkitRunnable bukkitRunnableSlow = new BukkitRunnable() {
            @Override
            public void run() {
                if (!isEnabled)
                    return;
                RedRings.run();
                RainbowArmor.run();
            }
        };
        bukkitRunnableSlow.runTaskTimer(plugin, 0, 5);

        // repeat 2ticks
        BukkitRunnable bukkitRunnableFast = new BukkitRunnable() {
            @Override
            public void run() {
                BlockTrailsClear.run();
                if (!isEnabled)
                    return;
                GoldBlockTrail.run();
                RainbowClayTrail.run();
                RainbowWoolTrail.run();
                RainbowGlassTrail.run();
                WheatBlockTrail.run();

                RainbowDustTrail.run();
                WaterParticleTrail.run();
                GreenParticleTrail.run();
                FlameParticleTrail.run();
                BlazeParticleTrail.run();
                LavaParticleTrail.run();
            }
        };
        bukkitRunnableFast.runTaskTimer(plugin, 0, 2);


        this.cosmeticPlayerManager = new CosmeticPlayerManager();




        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aGeladen!");
    }

    public void onDisable() {
        // console
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cDas Plugin wird gestoppt...");
        MySQLCosmetics.disconnect();
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cGestoppt!");
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GUIListener(this), this);
        pm.registerEvents(new MainListener(), this);
        pm.registerEvents(new FlightStick(), this);
        pm.registerEvents(new Firework(this), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public static boolean getIsEnabled() {
        return isEnabled;
    }

    public PlaySound getPlaySound() {
        return playSound;
    }

    public static void setIsEnabled(boolean enable) {
        isEnabled = enable;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<Player, String> current : Main.helmet.entrySet()) {
                    current.getKey().getInventory().setHelmet(null);
                }
                for (Map.Entry<Player, String> current : Main.chestplate.entrySet()) {
                    current.getKey().getInventory().setChestplate(null);
                }
                for (Map.Entry<Player, String> current : Main.pants.entrySet()) {
                    current.getKey().getInventory().setLeggings(null);
                }
                for (Map.Entry<Player, String> current : Main.shoes.entrySet()) {
                    current.getKey().getInventory().setBoots(null);
                }
            }
        }, 10);
    }

    public CosmeticPlayerManager getCosmeticPlayerManager() {
        return cosmeticPlayerManager;
    }

}
