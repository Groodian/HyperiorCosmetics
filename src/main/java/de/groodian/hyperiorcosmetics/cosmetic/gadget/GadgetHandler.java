package de.groodian.hyperiorcosmetics.cosmetic.gadget;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public abstract class GadgetHandler<T extends GadgetCosmetic> extends CosmeticHandler<T> implements Listener {

    private final String uuid;

    private long time = 0;
    private int timeout;

    public GadgetHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        super(cosmeticPlayer, cosmetic);
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void onEquip() {
        ItemStack inventoryItem = new ItemBuilder(cosmetic.getGadgetItem().clone())
                .addCustomData("interact", PersistentDataType.STRING, uuid)
                .build();
        cosmeticPlayer.getPlayer().getInventory().setItem(HyperiorCosmetic.GADGET_SLOT, inventoryItem);
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
        if (!cosmeticPlayer.getHyperiorCosmetic().isActive()) {
            return;
        }

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().equals(cosmeticPlayer.getPlayer())) {
                ItemStack itemInMainHand = e.getPlayer().getInventory().getItemInMainHand();
                String interact = ItemBuilder.getCustomData(itemInMainHand, "interact", PersistentDataType.STRING);
                if (interact != null) {
                    if (interact.equals(uuid)) {
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

    protected abstract void onRightClickAndNoTimeout(PlayerInteractEvent e);

}
