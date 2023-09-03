package de.groodian.hyperiorcosmetics;

import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.menu.MainMenu;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class MainListener implements Listener {

    private final HyperiorCosmetic hyperiorCosmetic;

    public MainListener(HyperiorCosmetic hyperiorCosmetic) {
        this.hyperiorCosmetic = hyperiorCosmetic;
    }

    @EventHandler
    public void handleAsyncPlayerJoin(AsyncPlayerPreLoginEvent e) {
        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticsDatabase().loadPlayer(e.getUniqueId());
        hyperiorCosmetic.getCosmeticPlayerManager().registerPlayer(cosmeticPlayer);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void handlePlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (hyperiorCosmetic.isActive() && !HyperiorCore.getPaper().getPrefix().isSpectator(player)) {
            player.getInventory().setItem(HyperiorCosmetic.COSMETIC_SLOT, HyperiorCosmetic.COSMETIC_ITEM);
            player.getInventory().setItem(HyperiorCosmetic.GADGET_SLOT, HyperiorCosmetic.NO_GADGET_EQUIPPED_ITEM);
            CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(player);
            cosmeticPlayer.activateCosmeticsToActivate();
        }
    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent e) {
        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(e.getPlayer());
        hyperiorCosmetic.getCosmeticPlayerManager().unregisterPlayer(cosmeticPlayer);
    }

    @EventHandler
    public void handleInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            String interact = ItemBuilder.getCustomData(itemInMainHand, "interact", PersistentDataType.STRING);
            if (interact != null) {
                if (interact.equals("Cosmetics")) {
                    CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(player);
                    hyperiorCosmetic.getCosmeticsGUIManager().open(player, new MainMenu(hyperiorCosmetic, cosmeticPlayer));
                }
            }
        }
    }

}
