package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;

public class GrowBlockHandler extends BlockHandler<ClassicBlockCosmetic> {

    private int age = 0;

    public GrowBlockHandler(CosmeticPlayer cosmeticPlayer, ClassicBlockCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
        BlockData blockData = cosmetic.getMaterial().createBlockData();

        if (blockData instanceof Ageable ageable) {
            ageable.setAge(age);
            setBlock(cosmetic.isOnGround(), blockData);
            age++;
            if (age > ageable.getMaximumAge()) {
                age = 0;
            }
        }

    }

}
