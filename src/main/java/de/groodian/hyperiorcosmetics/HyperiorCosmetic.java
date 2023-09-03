package de.groodian.hyperiorcosmetics;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcore.gui.GUIManager;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticCollection;
import de.groodian.hyperiorcosmetics.cosmetic.block.BlockCollection;
import de.groodian.hyperiorcosmetics.cosmetic.gadget.GadgetCollection;
import de.groodian.hyperiorcosmetics.cosmetic.particle.ParticleCollection;
import de.groodian.hyperiorcosmetics.cosmetic.suit.SuitCollection;
import de.groodian.hyperiorcosmetics.menu.CrateMenu;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayerManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperiorCosmetic extends JavaPlugin {

    public static final Component PREFIX = Component.text("Cosmetics", NamedTextColor.GREEN)
            .append(Component.text(" » ", NamedTextColor.GRAY));
    public static final String PREFIX_LEGACY = "§aCosmetics §7§ ";
    public static final int COSMETIC_SLOT = 4;
    public static final int GADGET_SLOT = 8;
    public static final ItemStack COSMETIC_ITEM = new ItemBuilder(Material.CHEST)
            .setName("§6§lKosmetik §7(Rechtsklick)")
            .addCustomData("interact", PersistentDataType.STRING, "Cosmetics")
            .build();
    public static final ItemStack NO_GADGET_EQUIPPED_ITEM = new ItemBuilder(Material.FIREWORK_STAR)
            .setName("§cKein Gadget ausgewählt!")
            .build();
    public static final CosmeticCollection PARTICLE_COLLECTION = new ParticleCollection();
    public static final CosmeticCollection BLOCK_COLLECTION = new BlockCollection();
    public static final SuitCollection SUIT_COLLECTION = new SuitCollection();
    public static final CosmeticCollection GADGET_COLLECTION = new GadgetCollection();

    private static HyperiorCosmetic instance;

    private long tick = 0;
    private boolean enabled = true;
    private CosmeticPlayerManager cosmeticPlayerManager;
    private CosmeticsDatabase cosmeticsDatabase;
    private GUIManager cosmeticsGUIManager;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX_LEGACY + "§aDas Plugin wird geladen...");

        instance = this;

        cosmeticPlayerManager = new CosmeticPlayerManager();
        cosmeticsDatabase = new CosmeticsDatabase(this);
        cosmeticsGUIManager = new GUIManager(GUI.class, this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MainListener(this), this);
        pm.registerEvents(cosmeticsGUIManager, this);

        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (enabled)
                cosmeticPlayerManager.updateAll(tick++);
        }, 40, 1);

        Bukkit.getConsoleSender().sendMessage(PREFIX_LEGACY + "§aGeladen!");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX_LEGACY + "§cDas Plugin wird gestoppt...");

        Bukkit.getConsoleSender().sendMessage(PREFIX_LEGACY + "§cGestoppt!");
    }

    public CosmeticPlayerManager getCosmeticPlayerManager() {
        return cosmeticPlayerManager;
    }

    public CosmeticsDatabase getCosmeticsDatabase() {
        return cosmeticsDatabase;
    }

    public GUIManager getCosmeticsGUIManager() {
        return cosmeticsGUIManager;
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

    public static void openCrateMenu(Player player) {
        if (instance != null) {
            if (instance.cosmeticsGUIManager != null) {
                CosmeticPlayer cosmeticPlayer = instance.getCosmeticPlayerManager().getCosmeticPlayer(player);
                instance.cosmeticsGUIManager.open(player, new CrateMenu(instance, cosmeticPlayer));
            }
        }
    }

    public boolean isActive() {
        return enabled;
    }

}
