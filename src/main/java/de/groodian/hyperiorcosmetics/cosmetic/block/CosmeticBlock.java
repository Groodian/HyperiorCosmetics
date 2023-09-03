package de.groodian.hyperiorcosmetics.cosmetic.block;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class CosmeticBlock {

    private final Location location;
    private final BlockData blockData;
    private final List<Player> placedFor;

    private int lifeTime;

    public CosmeticBlock(Location location, BlockData blockData, int lifeTime, List<Player> placedFor) {
        this.location = location;

        this.blockData = blockData;
        this.lifeTime = lifeTime;
        this.placedFor = placedFor;
    }

    public void remove() {
        for (Player placedFor : placedFor) {
            if (placedFor.getWorld().equals(location.getWorld())) {
                placedFor.sendBlockChange(location, blockData);
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
