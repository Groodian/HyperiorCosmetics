package de.groodian.cosmetics.cosmetic.gadget;

import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class SnowCanonHandler extends GadgetHandler<GadgetCosmetic> {

    private List<Snowball> snowballs;

    public SnowCanonHandler(CosmeticPlayer cosmeticPlayer, GadgetCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
        snowballs = new ArrayList<>();
    }

    @Override
    protected void update() {
        List<Snowball> toRemove = new ArrayList<>();
        for (Snowball snowball : snowballs) {
            if (snowball.isOnGround() || snowball.isDead()) {
                toRemove.add(snowball);
            } else {
                new Particle(EnumParticle.FIREWORKS_SPARK).send(snowball.getLocation());
            }
        }
        for (Snowball snowball : toRemove) {
            snowballs.remove(snowball);
        }
    }

    @Override
    protected void onRightClickAndNoTimeout(PlayerInteractEvent e) {
        snowballs.add(cosmeticPlayer.getPlayer().launchProjectile(Snowball.class));
    }

}
