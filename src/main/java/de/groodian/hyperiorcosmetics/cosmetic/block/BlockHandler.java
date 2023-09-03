package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.VoxelShape;

public abstract class BlockHandler<T extends Cosmetic> extends CosmeticHandler<T> {

    private static final int LIFE_TIME = 7;
    private static final int DISTANCE = 25;

    private final List<CosmeticBlock> blocks;

    public BlockHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        super(cosmeticPlayer, cosmetic);
        blocks = new ArrayList<>();
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        // clean or update existing blocks
        List<CosmeticBlock> toRemove = new ArrayList<>();
        for (CosmeticBlock cosmeticBlock : blocks) {
            if (cosmeticBlock.getLifeTime() <= 0) {
                cosmeticBlock.remove();
                toRemove.add(cosmeticBlock);
            } else {
                cosmeticBlock.removeLifeTime();
            }
        }
        for (CosmeticBlock cosmeticBlock : toRemove) {
            blocks.remove(cosmeticBlock);
        }

        update();
    }

    protected abstract void update();

    protected void setBlock(boolean onGround, Material material) {
        setBlock(onGround, material.createBlockData());
    }

    protected void setBlock(boolean onGround, BlockData blockData) {
        Location location = cosmeticPlayer.getPlayer().getLocation();
        boolean setBlock = true;
        if (!onGround) {
            location.add(0, -1, 0);
            if (!isCube(location.getBlock())) {
                setBlock = false;
            }
        } else {
            if (location.getBlock().getType() != Material.AIR) {
                setBlock = false;
            } else {
                if (!isCube(location.clone().add(0, -1, 0).getBlock())) {
                    setBlock = false;
                }
            }
        }
        Block block = location.getBlock();
        if (setBlock) {
            List<Player> placedFor = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.getWorld().equals(block.getWorld()) && all.getLocation().distance(block.getLocation()) <= DISTANCE) {
                    all.sendBlockChange(block.getLocation(), blockData);
                    placedFor.add(all);
                }
            }
            blocks.add(new CosmeticBlock(block.getLocation(), block.getBlockData(), LIFE_TIME, placedFor));
        }
    }

    @Override
    public void onDisable() {
        for (CosmeticBlock cosmeticBlock : blocks) {
            cosmeticBlock.remove();
        }
    }

    private boolean isCube(Block block) {
        VoxelShape voxelShape = block.getCollisionShape();
        BoundingBox boundingBox = block.getBoundingBox();
        return (voxelShape.getBoundingBoxes().size() == 1
                && boundingBox.getWidthX() == 1.0
                && boundingBox.getHeight() == 1.0
                && boundingBox.getWidthZ() == 1.0
        );
    }

}
