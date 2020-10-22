package de.groodian.cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CosmeticPlayer {

    private UUID uuid;
    private int[] cosmeticIds;
    private List<Cosmetic> cosmeticsToActivate;

    private Map<Category, CosmeticHandler<?>> activeCosmetics;

    /**
     * This constructor should be executed async
     */
    public CosmeticPlayer(UUID uuid) {
        this.uuid = uuid;
        cosmeticsToActivate = new ArrayList<>();
        activeCosmetics = new HashMap<>();
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        cosmeticIds = CosmeticMySQL.getCosmeticIds(uuid);
        if (cosmeticIds == null) {
            cosmeticIds = new int[0];
        }

        for (Category category : Category.values()) {
            int id = CosmeticMySQL.getActivatedCosmeticId(uuid, category);
            if (id > 0) {
                Cosmetic cosmetic = Cosmetic.getCosmeticsById(id);
                if (cosmetic != null) {
                    cosmeticsToActivate.add(cosmetic);
                }
            }
        }
    }

    public void activateCosmeticsToActivate() {
        for (Cosmetic cosmetic : cosmeticsToActivate) {
            equip(cosmetic);
        }
        cosmeticsToActivate.clear();
    }

    public void equip(Cosmetic cosmetic) {
        try {
            if (isOwningCosmetic(cosmetic)) {
                ParameterizedType parameterizedType = (ParameterizedType) cosmetic.getClazz().getGenericSuperclass();
                Class<?> genericClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                CosmeticHandler<?> instance = cosmetic.getClazz().getDeclaredConstructor(CosmeticPlayer.class, genericClass).newInstance(this, cosmetic);
                disableCosmetic(cosmetic.getCategory());
                instance.onEquip();
                CosmeticMySQL.activate(getPlayer(), cosmetic);
                activeCosmetics.put(cosmetic.getCategory(), instance);
                getPlayer().sendMessage(cosmetic.getRarity().getColor() + cosmetic.getName() + "§a aktiviert!");
            }
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

    public void disableAll() {
        for (Category category : Category.values()) {
            disableCosmetic(category);
        }
    }

    public void addCosmetic(Cosmetic cosmetic) {
        CosmeticMySQL.add(getPlayer(), cosmetic);
        int[] newCosmeticIds = new int[cosmeticIds.length + 1];
        for (int i = 0; i < cosmeticIds.length; i++) {
            newCosmeticIds[i] = cosmeticIds[i];
        }
        newCosmeticIds[cosmeticIds.length] = cosmetic.getId();
        cosmeticIds = newCosmeticIds;
    }

    public boolean isOwningCosmetic(Cosmetic cosmetic) {
        for (Integer integer : cosmeticIds) {
            if (integer == cosmetic.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveCosmetic(Cosmetic cosmetic) {
        for (CosmeticHandler<?> cosmeticHandler : activeCosmetics.values()) {
            if (cosmetic.equals(cosmeticHandler.getCosmetic())) {
                return true;
            }
        }
        return false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
