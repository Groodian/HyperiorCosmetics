package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class RainbowWingParticleHandler extends WingParticleHandler<DefaultCosmetic> {

    private static final int SPEED = 5;

    private int red = 255;
    private int green = 0;
    private int blue = 0;

    public RainbowWingParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        for (int i = 0; i < SPEED; i++) {
            if (red > 0 && blue == 0) {
                red--;
                green++;
            }
            if (green > 0 && red == 0) {
                green--;
                blue++;
            }
            if (blue > 0 && green == 0) {
                red++;
                blue--;
            }
        }
        setWing(new Particle(EnumParticle.REDSTONE, false, red, green, blue, 1, 0, 0));
    }

    @Override
    public void onDisable() {
    }

}
