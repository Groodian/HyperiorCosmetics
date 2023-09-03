package de.groodian.hyperiorcosmetics.player;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;

public class CosmeticPlayerManager {

    private final List<CosmeticPlayer> cosmeticPlayers;

    public CosmeticPlayerManager() {
        cosmeticPlayers = new ArrayList<>();
    }

    public void registerPlayer(CosmeticPlayer cosmeticPlayer) {
        cosmeticPlayers.add(cosmeticPlayer);
    }

    public void unregisterPlayer(CosmeticPlayer cosmeticPlayer) {
        // To call on every active cosmetic onDisable!
        cosmeticPlayer.pause();
        cosmeticPlayers.remove(cosmeticPlayer);
    }

    public void updateAll(long tick) {
        for (CosmeticPlayer cosmeticPlayer : cosmeticPlayers) {
            cosmeticPlayer.update(tick);
        }
    }

    public void pauseAll() {
        for (CosmeticPlayer cosmeticPlayer : cosmeticPlayers) {
            cosmeticPlayer.pause();
        }
    }

    public void resumeAll() {
        for (CosmeticPlayer cosmeticPlayer : cosmeticPlayers) {
            cosmeticPlayer.resume();
        }
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
