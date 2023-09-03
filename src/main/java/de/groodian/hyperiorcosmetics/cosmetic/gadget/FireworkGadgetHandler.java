package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.Random;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkGadgetHandler extends GadgetHandler<GadgetCosmetic> {

    private final Random random;

    public FireworkGadgetHandler(CosmeticPlayer cosmeticPlayer, GadgetCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
        random = new Random();
    }

    @Override
    protected void update() {
    }

    @Override
    protected void onRightClickAndNoTimeout(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null) {
            Firework firework = (Firework) e.getPlayer()
                    .getWorld()
                    .spawnEntity(e.getClickedBlock().getLocation().add(0, 1.5, 0), EntityType.FIREWORK);
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            FireworkEffect.Type fireworkType = FireworkEffect.Type.values()[random.nextInt(FireworkEffect.Type.values().length)];
            Color c1 = Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            Color c2 = Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            FireworkEffect fireworkEffect = FireworkEffect.builder()
                    .flicker(random.nextBoolean())
                    .withColor(c1)
                    .withFade(c2)
                    .with(fireworkType)
                    .trail(random.nextBoolean())
                    .build();
            fireworkMeta.addEffect(fireworkEffect);
            fireworkMeta.setPower(random.nextInt(2) + 2);
            firework.setFireworkMeta(fireworkMeta);
        }
    }

}
