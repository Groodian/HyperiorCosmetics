package de.groodian.cosmetics.cosmetic.block;

import de.groodian.cosmetics.player.CosmeticPlayer;

public class ClassicBlockHandler extends BlockHandler<BlockCosmetic> {

    public ClassicBlockHandler(CosmeticPlayer cosmeticPlayer, BlockCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
        setBlock(cosmetic.isOnGround(), cosmetic.getMaterial(), cosmetic.getSubId());
    }

}
