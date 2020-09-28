package de.groodian.cosmetics.trails;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.mysql.Cosmetics;

public class GUI implements Listener {

	public static final String GUI_NAME = "§4Trails";
	public static final String GUI_NAME_BLOCKTRAILS = "§4Trails §7» §6Block Spuren";
	public static final String GUI_NAME_PARTICLETRAILS = "§4Trails §7» §cPartikel";
	public static final String GUI_NAME_ARMOR = "§4Trails §7» §bRüstungen";
	public static final String GUI_NAME_SPECIAL = "§4Trails §7» §4Spezial";

	private static Main plugin;

	public GUI(Main plugin) {
		GUI.plugin = plugin;
	}

	public static void openGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 45, GUI_NAME);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
			}
		}.runTaskLater(plugin, 3);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(37, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(43, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 6);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(2, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(6, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(38, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(42, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(27, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(35, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 9);
		new BukkitRunnable() {

			@Override
			public void run() {
				inventory.setItem(13, new ItemBuilder(Material.GOLD_BLOCK).setName("§8» §6Block Spuren").build());
				inventory.setItem(20, new ItemBuilder(Material.BLAZE_POWDER).setName("§8» §cPartikel").build());
				inventory.setItem(24, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("§8» §bRüstungen").build());
				inventory.setItem(31, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §4Spezial").build());
			}
		}.runTaskLater(plugin, 12);
		player.openInventory(inventory);
		plugin.getPlaySound().playSoundFor(Sound.CHEST_OPEN, player);
	}

	public static void openBlockTrailGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 45, GUI_NAME_BLOCKTRAILS);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
			}
		}.runTaskLater(plugin, 3);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(37, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(43, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 6);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(2, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(6, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(38, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(42, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(27, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(35, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 9);
		new BukkitRunnable() {

			@Override
			public void run() {
				if(Cosmetics.has(player, TrailsNames.GOLD_BLOCK_TRAIL))
					inventory.setItem(20, new ItemBuilder(Material.GOLD_BLOCK).setName(TrailsNames.GOLD_BLOCK_TRAIL_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(20, new ItemBuilder(Material.GOLD_BLOCK).setName(TrailsNames.GOLD_BLOCK_TRAIL_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e6.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.RAINBOW_GLASS_TRAIL))
					inventory.setItem(13, new ItemBuilder(Material.GLASS).setName(TrailsNames.RAINBOW_GLASS_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(13, new ItemBuilder(Material.GLASS).setName(TrailsNames.RAINBOW_GLASS_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.WHEAT_TRAIL))
					inventory.setItem(24, new ItemBuilder(Material.WHEAT).setName(TrailsNames.WHEAT_TRAIL_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(24, new ItemBuilder(Material.WHEAT).setName(TrailsNames.WHEAT_TRAIL_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e48.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.RAINBOW_WOOL_TRAIL))
					inventory.setItem(22, new ItemBuilder(Material.WOOL).setName(TrailsNames.RAINBOW_WOOL_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(22, new ItemBuilder(Material.WOOL).setName(TrailsNames.RAINBOW_WOOL_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.RAINBOW_CLAY_TRAIL))
					inventory.setItem(31, new ItemBuilder(Material.STAINED_CLAY).setName(TrailsNames.RAINBOW_CLAY_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(31, new ItemBuilder(Material.STAINED_CLAY).setName(TrailsNames.RAINBOW_CLAY_TRAIL_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").build());
			}
		}.runTaskLater(plugin, 12);
		player.openInventory(inventory);
		plugin.getPlaySound().playSoundFor(Sound.ENDERDRAGON_WINGS, player);
	}

	public static void openParticleTrailGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 45, GUI_NAME_PARTICLETRAILS);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
			}
		}.runTaskLater(plugin, 3);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(37, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(43, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 6);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(2, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(6, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(38, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(42, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(27, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(35, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 9);
		new BukkitRunnable() {

			@Override
			public void run() {
				if(Cosmetics.has(player, TrailsNames.BLAZE_PARTICLE))
					inventory.setItem(20, new ItemBuilder(Material.BLAZE_ROD).setName(TrailsNames.BLAZE_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(20, new ItemBuilder(Material.BLAZE_ROD).setName(TrailsNames.BLAZE_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e6.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.FLAME_PARTICLE))
					inventory.setItem(13, new ItemBuilder(Material.BLAZE_POWDER).setName(TrailsNames.FLAME_PARTICLE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(13, new ItemBuilder(Material.BLAZE_POWDER).setName(TrailsNames.FLAME_PARTICLE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.GREEN_PARTICLE))
					inventory.setItem(31, new ItemBuilder(Material.EMERALD).setName(TrailsNames.GREEN_PARTICLE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(31, new ItemBuilder(Material.EMERALD).setName(TrailsNames.GREEN_PARTICLE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.LAVA_PARTICLE))
					inventory.setItem(21, new ItemBuilder(Material.LAVA_BUCKET).setName(TrailsNames.LAVA_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(21, new ItemBuilder(Material.LAVA_BUCKET).setName(TrailsNames.LAVA_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e6.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.RAINBOW_PARTICLE))
					inventory.setItem(24, new ItemBuilder(Material.GLOWSTONE_DUST).setName(TrailsNames.RAINBOW_PARTICLE_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(24, new ItemBuilder(Material.GLOWSTONE_DUST).setName(TrailsNames.RAINBOW_PARTICLE_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e48.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.WATER_PARTICLE))
					inventory.setItem(22, new ItemBuilder(Material.WATER_BUCKET).setName(TrailsNames.WATER_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(22, new ItemBuilder(Material.WATER_BUCKET).setName(TrailsNames.WATER_PARTICLE_NAME).setLore("", "§7Seltenheit: §9Selten", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e6.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.REDRINGS))
					inventory.setItem(23, new ItemBuilder(Material.REDSTONE).setName(TrailsNames.REDRINGS_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(23, new ItemBuilder(Material.REDSTONE).setName(TrailsNames.REDRINGS_NAME).setLore("", "§7Seltenheit: §bLegendär", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e48.000 §6Coins").build());
			}
		}.runTaskLater(plugin, 12);
		player.openInventory(inventory);
		plugin.getPlaySound().playSoundFor(Sound.ENDERDRAGON_WINGS, player);
	}
	
	public static void openArmorTrailGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, GUI_NAME_ARMOR);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(45, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(53, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
			}
		}.runTaskLater(plugin, 3);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(46, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(51, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 6);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(2, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(6, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(47, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(52, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 9);
		new BukkitRunnable() {

			@Override
			public void run() {
				if(Cosmetics.has(player, TrailsNames.LEATHER_HELMET))
					inventory.setItem(11, new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.LEATHER_HELMET_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(11, new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.LEATHER_HELMET_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.LEATHER_CHESTPLATE))
					inventory.setItem(20, new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.LEATHER_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(20, new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.LEATHER_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.LEATHER_PANTS))
					inventory.setItem(29, new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.LEATHER_PANTS_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(29, new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.LEATHER_PANTS_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.LEATHER_SHOES))
					inventory.setItem(38, new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.LEATHER_SHOES_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(38, new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.LEATHER_SHOES_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());			
				if(Cosmetics.has(player, TrailsNames.CHAINMAIL_HELMET))
					inventory.setItem(12, new ItemBuilder(Material.CHAINMAIL_HELMET).setName(TrailsNames.CHAINMAIL_HELMET_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(12, new ItemBuilder(Material.CHAINMAIL_HELMET).setName(TrailsNames.CHAINMAIL_HELMET_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.CHAINMAIL_CHESTPLATE))
					inventory.setItem(21, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName(TrailsNames.CHAINMAIL_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(21, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName(TrailsNames.CHAINMAIL_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.CHAINMAIL_PANTS))
					inventory.setItem(30, new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setName(TrailsNames.CHAINMAIL_PANTS_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(30, new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setName(TrailsNames.CHAINMAIL_PANTS_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.CHAINMAIL_SHOES))
					inventory.setItem(39, new ItemBuilder(Material.CHAINMAIL_BOOTS).setName(TrailsNames.CHAINMAIL_SHOES_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(39, new ItemBuilder(Material.CHAINMAIL_BOOTS).setName(TrailsNames.CHAINMAIL_SHOES_NAME).setLore("", "§7Seltenheit: §7Gewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e1.500 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.GOLD_HELMET))
					inventory.setItem(13, new ItemBuilder(Material.GOLD_HELMET).setName(TrailsNames.GOLD_HELMET_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(13, new ItemBuilder(Material.GOLD_HELMET).setName(TrailsNames.GOLD_HELMET_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.GOLD_CHESTPLATE))
					inventory.setItem(22, new ItemBuilder(Material.GOLD_CHESTPLATE).setName(TrailsNames.GOLD_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(22, new ItemBuilder(Material.GOLD_CHESTPLATE).setName(TrailsNames.GOLD_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.GOLD_PANTS))
					inventory.setItem(31, new ItemBuilder(Material.GOLD_LEGGINGS).setName(TrailsNames.GOLD_PANTS_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(31, new ItemBuilder(Material.GOLD_LEGGINGS).setName(TrailsNames.GOLD_PANTS_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.GOLD_SHOES))
					inventory.setItem(40, new ItemBuilder(Material.GOLD_BOOTS).setName(TrailsNames.GOLD_SHOES_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(40, new ItemBuilder(Material.GOLD_BOOTS).setName(TrailsNames.GOLD_SHOES_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.DIAMOND_HELMET))
					inventory.setItem(14, new ItemBuilder(Material.DIAMOND_HELMET).setName(TrailsNames.DIAMOND_HELMET_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(14, new ItemBuilder(Material.DIAMOND_HELMET).setName(TrailsNames.DIAMOND_HELMET_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.DIAMOND_CHESTPLATE))
					inventory.setItem(23, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName(TrailsNames.DIAMOND_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(23, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName(TrailsNames.DIAMOND_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.DIAMOND_PANTS))
					inventory.setItem(32, new ItemBuilder(Material.DIAMOND_LEGGINGS).setName(TrailsNames.DIAMOND_PANTS_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(32, new ItemBuilder(Material.DIAMOND_LEGGINGS).setName(TrailsNames.DIAMOND_PANTS_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.DIAMOND_SHOES))
					inventory.setItem(41, new ItemBuilder(Material.DIAMOND_BOOTS).setName(TrailsNames.DIAMOND_SHOES_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				else
					inventory.setItem(41, new ItemBuilder(Material.DIAMOND_BOOTS).setName(TrailsNames.DIAMOND_SHOES_NAME).setLore("", "§7Seltenheit: §aUngewöhnlich", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e3.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.RAINBOW_HELMET))
					inventory.setItem(15, new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.RAINBOW_HELMET_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").setColorAndBuild(148, 0, 211));
				 else 
					inventory.setItem(15, new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.RAINBOW_HELMET_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").setColorAndBuild(148, 0, 211));
				if(Cosmetics.has(player, TrailsNames.RAINBOW_CHESTPLATE))
					inventory.setItem(24, new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.RAINBOW_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").setColorAndBuild(148, 0, 211));
				 else 
					inventory.setItem(24, new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.RAINBOW_CHESTPLATE_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").setColorAndBuild(148, 0, 211));
				if(Cosmetics.has(player, TrailsNames.RAINBOW_PANTS))
					inventory.setItem(33, new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.RAINBOW_PANTS_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").setColorAndBuild(148, 0, 211));
				 else 
					inventory.setItem(33, new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.RAINBOW_PANTS_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").setColorAndBuild(148, 0, 211));
				if(Cosmetics.has(player, TrailsNames.RAINBOW_SHOES))
					inventory.setItem(42, new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.RAINBOW_SHOES_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").setColorAndBuild(148, 0, 211));
				 else 
					inventory.setItem(42, new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.RAINBOW_SHOES_NAME).setLore("", "§7Seltenheit: §dEpisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e24.000 §6Coins").setColorAndBuild(148, 0, 211));
				
			}
		}.runTaskLater(plugin, 12);
		player.openInventory(inventory);
		plugin.getPlaySound().playSoundFor(Sound.ENDERDRAGON_WINGS, player);
	}

	public static void openSpecialTrailGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 45, GUI_NAME_SPECIAL);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(0, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(8, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(36, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
				inventory.setItem(44, (new ItemBuilder(Material.STAINED_GLASS_PANE)).setName("§a").build());
			}
		}.runTaskLater(plugin, 3);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(1, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(7, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(37, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(43, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 6);
		new BukkitRunnable() {
			public void run() {
				inventory.setItem(2, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(6, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(38, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(42, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(9, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(17, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(27, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
				inventory.setItem(35, (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7)).setName("§a").build());
			}
		}.runTaskLater(plugin, 9);
		new BukkitRunnable() {

			@Override
			public void run() {
				if(Cosmetics.has(player, TrailsNames.FLIGHT_STICK))
					inventory.setItem(21, new ItemBuilder(Material.BLAZE_ROD).setName(TrailsNames.FLIGHT_STICK_NAME).setLore("", "§7Seltenheit: §cSchwarzmarktware", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				 else 
					inventory.setItem(21, new ItemBuilder(Material.BLAZE_ROD).setName(TrailsNames.FLIGHT_STICK_NAME).setLore("", "§7Seltenheit: §cSchwarzmarktware", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e200.000 §6Coins").build());
				if(Cosmetics.has(player, TrailsNames.FIREWORK))
					inventory.setItem(23, new ItemBuilder(Material.FIREWORK).setName(TrailsNames.FIREWORK_NAME).setLore("", "§7Seltenheit: §6Mystisch", "", "§aDu besitzt diesen Gegenstand.", "", "§7Klicke hier um den", "§7Gegenstand auszurüsten.").build());
				 else 
					inventory.setItem(23, new ItemBuilder(Material.FIREWORK).setName(TrailsNames.FIREWORK_NAME).setLore("", "§7Seltenheit: §6Mystisch", "", "§cDu besitzt diesen Gegenstand", "§cnoch nicht.", "", "§7Klicke hier als §cGründer §7um", "§7den Gegenstand zu Kaufen.", "", "§7Preis: §e150.000 §6Coins").build());
			}
		}.runTaskLater(plugin, 12);
		player.openInventory(inventory);
		plugin.getPlaySound().playSoundFor(Sound.ENDERDRAGON_WINGS, player);
	}
}