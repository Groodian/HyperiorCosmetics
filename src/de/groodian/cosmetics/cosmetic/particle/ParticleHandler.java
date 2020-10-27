package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.Location;

public abstract class ParticleHandler<T extends Cosmetic> extends CosmeticHandler<T> {

    public ParticleHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    protected Location rotateAroundYAxis(Location center, Location location, float degree) {
        double distanceX = center.getX() - location.getX();
        double distanceZ = center.getZ() - location.getZ();
        double rotation = Math.toRadians(degree);
        double cos = Math.cos(rotation);
        double sin = Math.sin(rotation);
        Location rotatedLocation = center.clone().add((distanceX * cos) - (distanceZ * sin), 0, (distanceX * sin) + (distanceZ * cos));
        rotatedLocation.setY(location.getY());
        return rotatedLocation;
    }

}
