package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

public class AdvancedBlockHandler extends BlockHandler<AdvancedBlockCosmetic> {

    private int pos = 0;

    public AdvancedBlockHandler(CosmeticPlayer cosmeticPlayer, AdvancedBlockCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
        setBlock(cosmetic.isOnGround(), cosmetic.getMaterials().get(pos));
        pos++;
        if (pos >= cosmetic.getMaterials().size()) {
            pos = 0;
        }
    }

}
