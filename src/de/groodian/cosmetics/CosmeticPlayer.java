package de.groodian.cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
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
            ParameterizedType parameterizedType = (ParameterizedType) cosmetic.getClazz().getGenericSuperclass();
            Class<?> genericClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
            CosmeticHandler<?> instance = cosmetic.getClazz().getDeclaredConstructor(CosmeticPlayer.class, genericClass).newInstance(this, cosmetic);
            disableCosmetic(cosmetic.getCategory());
            instance.onEquip();
            CosmeticMySQL.activate(getPlayer(), cosmetic);
            activeCosmetics.put(cosmetic.getCategory(), instance);
            getPlayer().sendMessage(cosmetic.getRarity().getColor() + cosmetic.getName() + "§a aktiviert!");
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void disableCosmetic(Category category) {
        if (activeCosmetics.containsKey(category)) {
            CosmeticHandler<?> cosmeticHandler = activeCosmetics.get(category);
            cosmeticHandler.onDisable();
            CosmeticMySQL.deactivate(getPlayer(), category);
            activeCosmetics.remove(category);
            getPlayer().sendMessage(cosmeticHandler.getCosmetic().getRarity().getColor() + cosmeticHandler.getCosmetic().getName() + "§c deaktiviert!");
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
