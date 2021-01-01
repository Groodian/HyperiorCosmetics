package de.groodian.cosmetics;

import de.groodian.cosmetics.player.CosmeticPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    private HyperiorCosmetic hyperiorCosmetic;

    public MainListener(HyperiorCosmetic hyperiorCosmetic) {
        this.hyperiorCosmetic = hyperiorCosmetic;
    }

    @EventHandler
    public void handleAsyncPlayerJoin(AsyncPlayerPreLoginEvent e) {
        CosmeticPlayer cosmeticPlayer = new CosmeticPlayer(e.getUniqueId(), hyperiorCosmetic);
        hyperiorCosmetic.getCosmeticPlayerManager().registerPlayer(cosmeticPlayer);
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (hyperiorCosmetic.isActive()) {
            player.getInventory().setItem(HyperiorCosmetic.COSMETIC_SLOT, HyperiorCosmetic.COSMETIC_ITEM);
            player.getInventory().setItem(HyperiorCosmetic.GADGET_SLOT, HyperiorCosmetic.NO_GADGET_EQUIPPED_ITEM);
        }

        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(player);
        cosmeticPlayer.activateCosmeticsToActivate();

        if (hyperiorCosmetic.isActive()) {
            cosmeticPlayer.pause();
        }
    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent e) {
        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(e.getPlayer());
        hyperiorCosmetic.getCosmeticPlayerManager().unregisterPlayer(cosmeticPlayer);
    }

    @EventHandler
    public void handleInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().equals(HyperiorCosmetic.COSMETIC_ITEM)) {
                    hyperiorCosmetic.getMainMenu().open(hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(e.getPlayer()));
                }
            }
        }
    }

}
