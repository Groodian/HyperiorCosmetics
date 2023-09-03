package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FlightStickGadgetHandler extends GadgetHandler<GadgetCosmetic> {

    public FlightStickGadgetHandler(CosmeticPlayer cosmeticPlayer, GadgetCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
    }

    @Override
    protected void onRightClickAndNoTimeout(PlayerInteractEvent e) {
        Player player = cosmeticPlayer.getPlayer();
        player.setVelocity(player.getLocation().getDirection().multiply(2).add(new Vector(0, 0.75, 0)));
    }

}
