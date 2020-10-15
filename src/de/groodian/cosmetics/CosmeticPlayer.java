package de.groodian.cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CosmeticPlayer {

    private UUID uuid;
    private int[] cosmeticIds;

    private Map<Category, CosmeticHandler<?>> activeCosmetics;

    public CosmeticPlayer(UUID uuid, int[] cosmeticIds) {
        this.uuid = uuid;
        this.cosmeticIds = cosmeticIds;

        activeCosmetics = new HashMap<>();
    }

    public void equip(Cosmetic cosmetic) {
        try {
            CosmeticHandler<?> instance = cosmetic.getClazz().getDeclaredConstructor(CosmeticPlayer.class, Cosmetic.class).newInstance(this, cosmetic);
            instance.onEquip();
            CosmeticMySQL.activate(getPlayer(), cosmetic);
            activeCosmetics.put(cosmetic.getCategory(), instance);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void disableCosmetic(Category category) {
        if (activeCosmetics.containsKey(category)) {
            CosmeticHandler<?> cosmeticHandler = activeCosmetics.get(category);
            cosmeticHandler.onDisable();
            activeCosmetics.remove(category);
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
