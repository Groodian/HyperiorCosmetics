package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;


public class WingParticleHandler extends CosmeticHandler<DefaultCosmetic> {

    private static final double SPACE = 0.2;

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

    private double wingOff = 0;

    public WingParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        Location location = cosmeticPlayer.getPlayer().getLocation();
        double xOff = -((shape[0].length * SPACE) / 2.0);
        double x = xOff;
        double y = 1 + ((shape.length * SPACE) / 2.0);

        for (boolean[] line : shape) {
            for (boolean entry : line) {
                if (entry) {
                    Location particlePos = rotateAroundYAxis(location, location.clone().add(x, y, 0.25), location.getYaw());
                    new Particle(EnumParticle.REDSTONE, particlePos, false, 1, 1, 1, 1, 0, 0).sendAll();
                }
                x += SPACE;
            }
            x = xOff;
            y -= SPACE;
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
