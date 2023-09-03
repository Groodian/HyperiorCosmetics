package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Color;
import org.bukkit.Particle;

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

        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(red, green, blue), 1.0f);
        setWing(new HParticle(Particle.REDSTONE, 1, dustOptions));
    }

    @Override
    public void onDisable() {
    }

}
