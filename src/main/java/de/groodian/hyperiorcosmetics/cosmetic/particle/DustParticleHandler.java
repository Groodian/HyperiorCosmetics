package de.groodian.hyperiorcosmetics.cosmetic.particle;

import de.groodian.hyperiorcore.util.HParticle;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.Color;
import org.bukkit.Particle;

public class DustParticleHandler extends ParticleHandler<DefaultCosmetic> {

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
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(red, green, blue), 1.0f);
            new HParticle(Particle.REDSTONE, 1, dustOptions).send(cosmeticPlayer.getPlayer().getLocation().add(0, f, 0));
        }
    }

    @Override
    public void onDisable() {
    }

}
