package de.groodian.cosmetics.trails.special;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.Random;

public class Firework implements Listener {

    private Main plugin;
    private ArrayList<Player> delay = new ArrayList<>();

    public Firework(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().getItemInHand() != null) {
                if (e.getPlayer().getItemInHand().getItemMeta() != null) {
                    if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(TrailsNames.FIREWORK_NAME + " §7(Rechtsklick)")) {
                            e.setCancelled(true);
                            if (!delay.contains(e.getPlayer())) {
                                delay.add(e.getPlayer());
                                org.bukkit.entity.Firework firework = (org.bukkit.entity.Firework) e.getPlayer().getWorld().spawnEntity(e.getClickedBlock().getLocation(), EntityType.FIREWORK);
                                FireworkMeta fireworkMeta = firework.getFireworkMeta();
                                Random ran = new Random();
                                int temp = ran.nextInt(5);
                                Type type = Type.BALL;
                                if (temp == 0) type = Type.BALL;
                                if (temp == 1) type = Type.BALL_LARGE;
                                if (temp == 2) type = Type.BURST;
                                if (temp == 3) type = Type.CREEPER;
                                if (temp == 4) type = Type.STAR;
                                Color c1 = getColor(ran.nextInt(17));
                                Color c2 = getColor(ran.nextInt(17));
                                FireworkEffect fireworkEffect = FireworkEffect.builder().flicker(ran.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(ran.nextBoolean()).build();
                                fireworkMeta.addEffect(fireworkEffect);
                                fireworkMeta.setPower(ran.nextInt(4));
                                firework.setFireworkMeta(fireworkMeta);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        delay.remove(e.getPlayer());
                                    }
                                }, 30);
                            }
                        }
                    }
                }
            }
        }
    }

    private Color getColor(int i) {
        if (i == 0) return Color.AQUA;
        if (i == 1) return Color.BLACK;
        if (i == 2) return Color.BLUE;
        if (i == 3) return Color.FUCHSIA;
        if (i == 4) return Color.GRAY;
        if (i == 5) return Color.GREEN;
        if (i == 6) return Color.LIME;
        if (i == 7) return Color.MAROON;
        if (i == 8) return Color.NAVY;
        if (i == 9) return Color.OLIVE;
        if (i == 10) return Color.ORANGE;
        if (i == 11) return Color.PURPLE;
        if (i == 12) return Color.RED;
        if (i == 13) return Color.SILVER;
        if (i == 14) return Color.TEAL;
        if (i == 15) return Color.WHITE;
        if (i == 16) return Color.YELLOW;
        return Color.WHITE;
    }
}
