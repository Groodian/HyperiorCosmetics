package de.groodian.cosmetics.cosmetic.gadget;

import de.groodian.cosmetics.HyperiorCosmetic;
import de.groodian.cosmetics.cosmetic.CosmeticHandler;
import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class GadgetHandler<T extends GadgetCosmetic> extends CosmeticHandler<T> implements Listener {

    private long time = 0;
    private int timeout;

    public GadgetHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
        cosmeticPlayer.getPlayer().getInventory().setItem(HyperiorCosmetic.GADGET_SLOT, cosmetic.getGadgetItem());
        cosmeticPlayer.getHyperiorCosmetic().getServer().getPluginManager().registerEvents(this, cosmeticPlayer.getHyperiorCosmetic());
    }

    @Override
    public void onUpdate() {
        if (timeout > 0) {
            timeout--;
        }
        if (cosmetic.getGadgetUpdateRate() > 0) {
            if (time % cosmetic.getGadgetUpdateRate() == 0) {
                update();
            }
        }

        time++;
    }

    protected abstract void update();

    @Override
    public void onDisable() {
        cosmeticPlayer.getPlayer().getInventory().setItem(HyperiorCosmetic.GADGET_SLOT, HyperiorCosmetic.NO_GADGET_EQUIPPED_ITEM);
        HandlerList.unregisterAll(this);
    }

    @EventHandler
    public void handleInteract(PlayerInteractEvent e) {
        if (cosmeticPlayer.getHyperiorCosmetic().isEnabled()) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getPlayer().equals(cosmeticPlayer.getPlayer())) {
                    if (e.getItem() != null) {
                        if (e.getItem().equals(cosmetic.getGadgetItem())) {
                            e.setCancelled(true);
                            if (timeout <= 0) {
                                onRightClickAndNoTimeout(e);
                                timeout = cosmetic.getDelay();
                            }
                        }
                    }
                }
            }
        }
    }

    protected abstract void onRightClickAndNoTimeout(PlayerInteractEvent e);

}
