package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class WingParticleHandler<T extends Cosmetic> extends ParticleHandler<T> {

    private static final double SPACE = 0.2;
    private static final double ANIMATION_SPACE = 0.04;

    private static final boolean x = true;
    private static final boolean o = false;
    private static final boolean[][] shape = {
            {o, o, x, o, o, o, o, o, o, o, o, o, o, o, x, o, o},
            {o, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, o},
            {o, o, x, x, x, x, x, o, o, o, x, x, x, x, x, o, o},
            {o, o, o, x, x, x, x, x, x, x, x, x, x, x, o, o, o},
            {o, o, o, o, x, x, x, x, x, x, x, x, x, o, o, o, o},
            {o, o, o, o, x, x, x, x, o, x, x, x, x, o, o, o, o},
            {o, o, o, o, o, x, x, x, o, x, x, x, o, o, o, o, o},
            {o, o, o, o, o, x, x, o, o, o, x, x, o, o, o, o, o},
            {o, o, o, o, x, x, o, o, o, o, o, x, x, o, o, o, o}
    };

    private double wingPos = 0;
    private boolean wingForwards = true;

    public WingParticleHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    protected void setWing(HParticle particle) {
        Player player = cosmeticPlayer.getPlayer();
        Location location = player.getLocation();

        double xOff = -((shape[0].length * SPACE) / 2.0);
        double yOff = 1 + ((shape.length * SPACE) / 2.0);
        double zOff = 0.25 + (((double) shape[0].length / 2) * ANIMATION_SPACE * wingPos);
        double x = xOff;
        double y = yOff;
        double z = zOff;

        for (boolean[] line : shape) {
            int count = 1;
            for (boolean entry : line) {
                if (entry) {
                    Location particlePos = rotateAroundYAxis(location, location.clone().add(x, y, z), player.getBodyYaw());
                    particle.send(particlePos);
                }
                x += SPACE;
                if ((line.length / 2) + 1 != count) {
                    if (count <= line.length / 2) {
                        z -= ANIMATION_SPACE * wingPos;
                    } else {
                        z += ANIMATION_SPACE * wingPos;
                    }
                }
                count++;
            }
            x = xOff;
            y -= SPACE;
            z = zOff;
        }

        if (wingForwards) {
            wingPos += 0.3;
            if (wingPos > 2.1) {
                wingForwards = false;
            }
        } else {
            wingPos -= 0.3;
            if (wingPos < -2.1) {
                wingForwards = true;
            }
        }
    }

}
