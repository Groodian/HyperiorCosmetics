package de.groodian.cosmetics;

import org.bukkit.entity.Player;

import java.util.UUID;

public class CosmeticPlayer {

    private UUID uuid;
    private int[] cosmeticIds;

    public CosmeticPlayer(UUID uuid, int[] cosmeticIds) {
        this.uuid = uuid;
        this.cosmeticIds = cosmeticIds;
    }

    public UUID getUuid() {
        return uuid;
    }
}
