package de.groodian.cosmetics.cosmetic.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class CosmeticBlock {

    private Location location;
    private Material material;
    private byte subId;
    private int lifeTime;
    private List<Player> placedFor;

    public CosmeticBlock(Location location, Material material, byte subId, int lifeTime, List<Player> placedFor) {
        this.location = location;
        this.material = material;
        this.subId = subId;
        this.lifeTime = lifeTime;
        this.placedFor = placedFor;
    }

    public void remove() {
        for (Player placedFor : placedFor) {
            if (placedFor.getWorld().equals(location.getWorld())) {
                placedFor.sendBlockChange(location, material, subId);
            }
        }
    }

    public Location getLocation() {
        return location;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void removeLifeTime() {
        lifeTime--;
    }

}
