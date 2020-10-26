package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import org.bukkit.Location;


public abstract class WingParticleHandler<T extends Cosmetic> extends CosmeticHandler<T> {

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

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        update();
    }

    protected abstract void update();

    protected void setWing(Particle particle) {
        Location location = cosmeticPlayer.getPlayer().getLocation();
        double xOff = -((shape[0].length * SPACE) / 2.0);
        double yOff = 1 + ((shape.length * SPACE) / 2.0);
        double zOff = 0.25 + ((shape[0].length / 2) * ANIMATION_SPACE * wingPos);
        double x = xOff;
        double y = yOff;
        double z = zOff;

        for (boolean[] line : shape) {
            int count = 1;
            for (boolean entry : line) {
                if (entry) {
                    Location particlePos = rotateAroundYAxis(location, location.clone().add(x, y, z), location.getYaw());
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

    private Location rotateAroundYAxis(Location center, Location location, float degree) {
        double distanceX = center.getX() - location.getX();
        double distanceZ = center.getZ() - location.getZ();
        double rotation = Math.toRadians(degree);
        double cos = Math.cos(rotation);
        double sin = Math.sin(rotation);
        Location rotatedLocation = center.clone().add((distanceX * cos) - (distanceZ * sin), 0, (distanceX * sin) + (distanceZ * cos));
        rotatedLocation.setY(location.getY());
        return rotatedLocation;
    }

    @Override
    public void onDisable() {
    }

}
