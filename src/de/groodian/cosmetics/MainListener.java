package de.groodian.cosmetics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    private HyperiorCosmetic plugin;

    public MainListener(HyperiorCosmetic plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerJoin(AsyncPlayerPreLoginEvent e) {
        CosmeticPlayer cosmeticPlayer = new CosmeticPlayer(e.getUniqueId());
        plugin.getCosmeticPlayerManager().registerPlayer(cosmeticPlayer);
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent e) {
        CosmeticPlayer cosmeticPlayer = plugin.getCosmeticPlayerManager().getCosmeticPlayer(e.getPlayer());
        cosmeticPlayer.activateCosmeticsToActivate();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        CosmeticPlayer cosmeticPlayer = plugin.getCosmeticPlayerManager().getCosmeticPlayer(e.getPlayer());
        plugin.getCosmeticPlayerManager().unregisterPlayer(cosmeticPlayer);
    }

}
