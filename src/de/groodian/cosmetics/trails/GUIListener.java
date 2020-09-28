package de.groodian.cosmetics.trails;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.groodian.cosmetics.main.Main;

public class GUIListener implements Listener {

	private Main plugin;

	public GUIListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void handleGUIClick(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player))
			return;
		Player player = (Player) e.getWhoClicked();

		if (e.getClickedInventory() != null) {
			if (e.getClickedInventory().getTitle() != null) {
				if (e.getClickedInventory().getTitle().equals(GUI.GUI_NAME)) {
					e.setCancelled(true);
					switch (e.getCurrentItem().getType()) {
					case GOLD_BLOCK:
						GUI.openBlockTrailGUI(player);
						break;
					case BLAZE_POWDER:
						GUI.openParticleTrailGUI(player);
						break;
					case ENDER_CHEST:
						GUI.openSpecialTrailGUI(player);
						break;
					case DIAMOND_CHESTPLATE:
						GUI.openArmorTrailGUI(player);
						break;
					default:
						break;
					}
				}

				if (e.getClickedInventory().getTitle().equals(GUI.GUI_NAME_BLOCKTRAILS)) {
					e.setCancelled(true);
					switch (e.getCurrentItem().getType()) {
					case GOLD_BLOCK:
						MasterActivatorTrails.run(player, TrailsNames.GOLD_BLOCK_TRAIL_NAME, TrailsNames.GOLD_BLOCK_TRAIL, 6000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GLASS:
						MasterActivatorTrails.run(player, TrailsNames.RAINBOW_GLASS_TRAIL_NAME, TrailsNames.RAINBOW_GLASS_TRAIL, 24000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case WHEAT:
						MasterActivatorTrails.run(player, TrailsNames.WHEAT_TRAIL_NAME, TrailsNames.WHEAT_TRAIL, 48000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case WOOL:
						MasterActivatorTrails.run(player, TrailsNames.RAINBOW_WOOL_TRAIL_NAME, TrailsNames.RAINBOW_WOOL_TRAIL, 24000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case STAINED_CLAY:
						MasterActivatorTrails.run(player, TrailsNames.RAINBOW_CLAY_TRAIL_NAME, TrailsNames.RAINBOW_CLAY_TRAIL, 24000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					default:
						break;
					}
				}

				if (e.getClickedInventory().getTitle().equals(GUI.GUI_NAME_PARTICLETRAILS)) {
					e.setCancelled(true);
					switch (e.getCurrentItem().getType()) {
					case BLAZE_ROD:
						MasterActivatorTrails.run(player, TrailsNames.BLAZE_PARTICLE_NAME, TrailsNames.BLAZE_PARTICLE, 6000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case BLAZE_POWDER:
						MasterActivatorTrails.run(player, TrailsNames.FLAME_PARTICLE_NAME, TrailsNames.FLAME_PARTICLE, 24000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case EMERALD:
						MasterActivatorTrails.run(player, TrailsNames.GREEN_PARTICLE_NAME, TrailsNames.GREEN_PARTICLE, 24000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case LAVA_BUCKET:
						MasterActivatorTrails.run(player, TrailsNames.LAVA_PARTICLE_NAME, TrailsNames.LAVA_PARTICLE, 6000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GLOWSTONE_DUST:
						MasterActivatorTrails.run(player, TrailsNames.RAINBOW_PARTICLE_NAME, TrailsNames.RAINBOW_PARTICLE, 48000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case WATER_BUCKET:
						MasterActivatorTrails.run(player, TrailsNames.WATER_PARTICLE_NAME, TrailsNames.WATER_PARTICLE, 6000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case REDSTONE:
						MasterActivatorTrails.run(player, TrailsNames.REDRINGS_NAME, TrailsNames.REDRINGS, 48000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					default:
						break;
					}
				}

				if (e.getClickedInventory().getTitle().equals(GUI.GUI_NAME_ARMOR)) {
					e.setCancelled(true);
					switch (e.getCurrentItem().getType()) {
					case LEATHER_HELMET:
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.RAINBOW_HELMET_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.RAINBOW_HELMET_NAME, TrailsNames.RAINBOW_HELMET, "helmet", 24000);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.LEATHER_HELMET_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.LEATHER_HELMET_NAME, TrailsNames.LEATHER_HELMET, "helmet", 1500);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
					case LEATHER_CHESTPLATE:
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.RAINBOW_CHESTPLATE_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.RAINBOW_CHESTPLATE_NAME, TrailsNames.RAINBOW_CHESTPLATE, "chestplate", 24000);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.LEATHER_CHESTPLATE_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.LEATHER_CHESTPLATE_NAME, TrailsNames.LEATHER_CHESTPLATE, "chestplate", 1500);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
					case LEATHER_LEGGINGS:
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.RAINBOW_PANTS_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.RAINBOW_PANTS_NAME, TrailsNames.RAINBOW_PANTS, "pants", 24000);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.LEATHER_PANTS_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.LEATHER_PANTS_NAME, TrailsNames.LEATHER_PANTS, "pants", 1500);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
					case LEATHER_BOOTS:
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.RAINBOW_SHOES_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.RAINBOW_SHOES_NAME, TrailsNames.RAINBOW_SHOES, "shoes", 24000);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
						if (e.getCurrentItem().getItemMeta().getDisplayName().equals(TrailsNames.LEATHER_SHOES_NAME)) {
							MasterActivatorArmor.run(player, TrailsNames.LEATHER_SHOES_NAME, TrailsNames.LEATHER_SHOES, "shoes", 1500);
							plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
							player.closeInventory();
							break;
						}
					case CHAINMAIL_HELMET:
						MasterActivatorArmor.run(player, TrailsNames.CHAINMAIL_HELMET_NAME, TrailsNames.CHAINMAIL_HELMET, "helmet", 1500);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case CHAINMAIL_CHESTPLATE:
						MasterActivatorArmor.run(player, TrailsNames.CHAINMAIL_CHESTPLATE_NAME, TrailsNames.CHAINMAIL_CHESTPLATE, "chestplate", 1500);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case CHAINMAIL_LEGGINGS:
						MasterActivatorArmor.run(player, TrailsNames.CHAINMAIL_PANTS_NAME, TrailsNames.CHAINMAIL_PANTS, "pants", 1500);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case CHAINMAIL_BOOTS:
						MasterActivatorArmor.run(player, TrailsNames.CHAINMAIL_SHOES_NAME, TrailsNames.CHAINMAIL_SHOES, "shoes", 1500);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GOLD_HELMET:
						MasterActivatorArmor.run(player, TrailsNames.GOLD_HELMET_NAME, TrailsNames.GOLD_HELMET, "helmet", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GOLD_CHESTPLATE:
						MasterActivatorArmor.run(player, TrailsNames.GOLD_CHESTPLATE_NAME, TrailsNames.GOLD_CHESTPLATE, "chestplate", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GOLD_LEGGINGS:
						MasterActivatorArmor.run(player, TrailsNames.GOLD_PANTS_NAME, TrailsNames.GOLD_PANTS, "pants", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case GOLD_BOOTS:
						MasterActivatorArmor.run(player, TrailsNames.GOLD_SHOES_NAME, TrailsNames.GOLD_SHOES, "shoes", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case DIAMOND_HELMET:
						MasterActivatorArmor.run(player, TrailsNames.DIAMOND_HELMET_NAME, TrailsNames.DIAMOND_HELMET, "helmet", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case DIAMOND_CHESTPLATE:
						MasterActivatorArmor.run(player, TrailsNames.DIAMOND_CHESTPLATE_NAME, TrailsNames.DIAMOND_CHESTPLATE, "chestplate", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case DIAMOND_LEGGINGS:
						MasterActivatorArmor.run(player, TrailsNames.DIAMOND_PANTS_NAME, TrailsNames.DIAMOND_PANTS, "pants", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case DIAMOND_BOOTS:
						MasterActivatorArmor.run(player, TrailsNames.DIAMOND_SHOES_NAME, TrailsNames.DIAMOND_SHOES, "shoes", 3000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					default:
						break;
					}
				}

				if (e.getClickedInventory().getTitle().equals(GUI.GUI_NAME_SPECIAL)) {
					e.setCancelled(true);
					switch (e.getCurrentItem().getType()) {
					case BLAZE_ROD:
						MasterActivatorGadget.run(player, TrailsNames.FLIGHT_STICK_NAME, TrailsNames.FLIGHT_STICK, 200000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					case FIREWORK:
						MasterActivatorGadget.run(player, TrailsNames.FIREWORK_NAME, TrailsNames.FIREWORK, 150000);
						plugin.getPlaySound().playSoundFor(Sound.NOTE_STICKS, player);
						player.closeInventory();
						break;
					default:
						break;
					}
				}
			}
		}
	}

}
