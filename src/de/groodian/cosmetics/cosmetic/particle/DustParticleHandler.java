package de.groodian.cosmetics.cosmetic.particle;

import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.cosmetic.DefaultCosmetic;
import de.groodian.cosmetics.player.CosmeticPlayer;
import de.groodian.hyperiorcore.util.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class DustParticleHandler extends CosmeticHandler<DefaultCosmetic> {

    private static final int SPEED = 10;

    private int red = 255;
    private int green = 0;
    private int blue = 0;

    public DustParticleHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
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

        for (float f = 0.1f; f < 0.5f; f += 0.1f) {
            new Particle(EnumParticle.REDSTONE, cosmeticPlayer.getPlayer().getLocation().add(0, f, 0), false, red / 255.0f, green / 255.0f, blue / 255.0f, 1, 0, 0).sendAll();
        }
    }

    @Override
    public void onDisable() {
    }

}
