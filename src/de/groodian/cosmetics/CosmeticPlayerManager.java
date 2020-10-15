package de.groodian.cosmetics;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CosmeticPlayerManager {

    private List<CosmeticPlayer> cosmeticPlayers;

    public CosmeticPlayerManager() {
        cosmeticPlayers = new ArrayList<>();
    }

    public void registerPlayer(CosmeticPlayer cosmeticPlayer) {
        cosmeticPlayers.add(cosmeticPlayer);
    }

    public void unregisterPlayer(CosmeticPlayer cosmeticPlayer) {
        cosmeticPlayers.remove(cosmeticPlayer);
    }

    public CosmeticPlayer getCosmeticPlayer(Player player) {
        for (CosmeticPlayer cosmeticPlayer : cosmeticPlayers) {
            if (cosmeticPlayer.getPlayer().equals(player)) {
                return cosmeticPlayer;
            }
        }
        return null;
    }

}