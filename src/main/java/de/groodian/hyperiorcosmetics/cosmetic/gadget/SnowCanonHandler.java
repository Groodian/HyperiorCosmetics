package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Particle;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;

public class SnowCanonHandler extends GadgetHandler<GadgetCosmetic> {

    private final List<Snowball> snowballs;

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
                new HParticle(Particle.FIREWORKS_SPARK, 0, null).send(snowball.getLocation());
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
