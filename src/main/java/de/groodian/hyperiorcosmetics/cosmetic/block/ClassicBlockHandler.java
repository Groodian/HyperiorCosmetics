package de.groodian.hyperiorcosmetics.cosmetic.block;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;

public class ClassicBlockHandler extends BlockHandler<ClassicBlockCosmetic> {

    public ClassicBlockHandler(CosmeticPlayer cosmeticPlayer, ClassicBlockCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    protected void update() {
        setBlock(cosmetic.isOnGround(), cosmetic.getMaterial());
    }

}
