package de.groodian.cosmetics;

import de.groodian.cosmetics.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class MainListener implements Listener {

    private Main plugin;

    public MainListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerJoin(AsyncPlayerPreLoginEvent e) {
        CosmeticPlayer cosmeticPlayer = new CosmeticPlayer(e.getUniqueId(), CosmeticMySQL.getCosmeticIds(e.getUniqueId()));
        plugin.getCosmeticPlayerManager().registerPlayer(cosmeticPlayer);
    }

}
