package de.groodian.cosmetics.cosmetic.block;

import de.groodian.cosmetics.cosmetic.Cosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BlockHandler<T extends Cosmetic> extends CosmeticHandler<T> {

    protected static final List<Integer> BLOCKED_BLOCKS = Arrays.asList(0, 6, 8, 9, 10, 11, 26, 27, 28, 30, 31, 32, 37, 38, 39, 40, 44, 50, 51, 53, 55, 59, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 75, 76, 77, 81, 83, 85, 90, 92, 93, 94, 96, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 114, 115, 116, 117, 118, 119, 120, 122, 126, 127, 128, 131, 132, 134, 135, 136, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 154, 156, 157, 160, 163, 164, 166, 167, 171, 175, 176, 177, 178, 180, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 203, 205, 207, 209, 217, 321, 323, 324, 330, 354, 355, 379, 380, 389, 397, 404, 425, 427, 428, 429, 430, 431);
    private static final int LIFE_TIME = 7;
    private static final int DISTANCE = 25;

    private List<CosmeticBlock> blocks;

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

    protected void setBlock(boolean onGround, Material material, byte subId) {
        Location location = cosmeticPlayer.getPlayer().getLocation();
        boolean setBlock = true;
        if (!onGround) {
            location.add(0, -1, 0);
            if (BLOCKED_BLOCKS.contains(location.getBlock().getTypeId())) {
                setBlock = false;
            }
        } else {
            if (location.getBlock().getType() != Material.AIR) {
                setBlock = false;
            } else {
                if (location.clone().add(0, -1, 0).getBlock().getType() == Material.AIR) {
                    setBlock = false;
                }
            }
        }
        Block block = location.getBlock();
        if (setBlock) {
            List<Player> placedFor = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.getWorld().equals(block.getWorld()) && all.getLocation().distance(block.getLocation()) <= DISTANCE) {
                    all.sendBlockChange(block.getLocation(), material, subId);
                    placedFor.add(all);
                }
            }
            blocks.add(new CosmeticBlock(block.getLocation(), block.getType(), block.getData(), LIFE_TIME, placedFor));
        }
    }

    @Override
    public void onDisable() {
        for (CosmeticBlock cosmeticBlock : blocks) {
            cosmeticBlock.remove();
        }
    }

}
