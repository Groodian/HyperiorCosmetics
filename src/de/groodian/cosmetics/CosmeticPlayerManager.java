package de.groodian.cosmetics;

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

}
