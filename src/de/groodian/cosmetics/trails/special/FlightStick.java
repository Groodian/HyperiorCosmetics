package de.groodian.cosmetics.trails.special;

import de.groodian.cosmetics.trails.TrailsNames;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FlightStick implements Listener {

    @EventHandler
    public void handleInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().getItemInHand() != null) {
                if (e.getPlayer().getItemInHand().getItemMeta() != null) {
                    if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(TrailsNames.FLIGHT_STICK_NAME + " §7(Rechtsklick)")) {
                            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(2).add(new Vector(0, 0.75, 0)));
                        }
                    }
                }
            }
        }
    }

}
