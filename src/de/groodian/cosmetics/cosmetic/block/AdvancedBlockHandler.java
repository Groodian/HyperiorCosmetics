package de.groodian.cosmetics.cosmetic.block;

import de.groodian.cosmetics.player.CosmeticPlayer;

public class AdvancedBlockHandler extends BlockHandler<BlockCosmetic> {

    private byte subId = 0;

    public AdvancedBlockHandler(CosmeticPlayer cosmeticPlayer, BlockCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
        setBlock(cosmetic.isOnGround(), cosmetic.getMaterial(), subId);
        subId++;
        if (subId >= cosmetic.getSubId()) {
            subId = 0;
        }
    }

}
