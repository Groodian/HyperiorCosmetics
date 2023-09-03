package de.groodian.hyperiorcosmetics.player;

import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcosmetics.CosmeticInDatabase;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CosmeticPlayer {

    private final UUID uuid;
    private final boolean isInDatabase;
    private final HyperiorCosmetic hyperiorCosmetic;
    private final List<Cosmetic> cosmeticsToActivate;
    private final List<CosmeticInDatabase> ownedCosmetics;
    private final Map<Category, CosmeticHandler<?>> activeCosmetics;

    public CosmeticPlayer(HyperiorCosmetic hyperiorCosmetic, UUID uuid, boolean isInDatabase, List<Cosmetic> cosmeticsToActivate,
                          List<CosmeticInDatabase> ownedCosmetics) {
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.uuid = uuid;
        this.isInDatabase = isInDatabase;
        this.cosmeticsToActivate = cosmeticsToActivate;
        this.ownedCosmetics = ownedCosmetics;
        activeCosmetics = new HashMap<>();
    }

    public void activateCosmeticsToActivate() {
        for (Cosmetic cosmetic : cosmeticsToActivate) {
            equip(cosmetic, true);
        }
        cosmeticsToActivate.clear();
    }

    public void equip(Cosmetic cosmetic) {
        equip(cosmetic, false);
    }

    public void equip(Cosmetic cosmetic, boolean onLogin) {
        try {
            if (isOwningCosmetic(cosmetic.getId())) {
                ParameterizedType parameterizedType = (ParameterizedType) cosmetic.getClazz().getGenericSuperclass();
                Class<?> genericClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                CosmeticHandler<?> instance = cosmetic.getClazz()
                        .getDeclaredConstructor(CosmeticPlayer.class, genericClass)
                        .newInstance(this, cosmetic);
                disableCosmetic(cosmetic.getCategory());
                instance.onEquip();
                activeCosmetics.put(cosmetic.getCategory(), instance);
                if (!onLogin) {
                    hyperiorCosmetic.getCosmeticsDatabase().activate(this, cosmetic);
                    getPlayer().sendMessage(HyperiorCosmetic.PREFIX
                            .append(Component.text(cosmetic.getName(), cosmetic.getRarity().getColor()))
                            .append(Component.text(" aktiviert!", NamedTextColor.GREEN)));
                }
            }
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void disableCosmetic(Category category) {
        if (activeCosmetics.containsKey(category)) {
            CosmeticHandler<?> cosmeticHandler = activeCosmetics.get(category);
            cosmeticHandler.onDisable();
            hyperiorCosmetic.getCosmeticsDatabase().deactivate(this, category);
            activeCosmetics.remove(category);
            getPlayer().sendMessage(HyperiorCosmetic.PREFIX
                    .append(Component.text(cosmeticHandler.getCosmetic().getName(), cosmeticHandler.getCosmetic().getRarity().getColor()))
                    .append(Component.text(" deaktiviert!", NamedTextColor.RED)));
        }
    }

    public void disableAll() {
        for (Category category : Category.values()) {
            disableCosmetic(category);
        }
    }

    public void pause() {
        for (CosmeticHandler<?> cosmeticHandler : activeCosmetics.values()) {
            cosmeticHandler.onDisable();
        }
    }

    public void resume() {
        if (!HyperiorCore.getPaper().getPrefix().isSpectator(getPlayer())) {
            if (cosmeticsToActivate.isEmpty()) {
                for (CosmeticHandler<?> cosmeticHandler : activeCosmetics.values()) {
                    cosmeticHandler.onEquip();
                }
            } else {
                activateCosmeticsToActivate();
            }
        }
    }

    public void addCosmetic(CosmeticInDatabase cosmeticInDatabase) {
        for (CosmeticInDatabase ownedCosmetic : ownedCosmetics) {
            if (ownedCosmetic.getId() == cosmeticInDatabase.getId()) {
                ownedCosmetic.setDuplicates(ownedCosmetic.getDuplicates() + 1);
                return;
            }
        }

        ownedCosmetics.add(cosmeticInDatabase);
    }

    public void update(long tick) {
        for (CosmeticHandler<?> cosmeticHandler : activeCosmetics.values()) {
            if (cosmeticHandler.getCosmetic().getUpdateRate() > 0) {
                if (tick % cosmeticHandler.getCosmetic().getUpdateRate() == 0) {
                    cosmeticHandler.onUpdate();
                }
            }
        }
    }

    public CosmeticInDatabase getOwnedCosmetic(int cosmeticId) {
        for (CosmeticInDatabase ownedCosmetic : ownedCosmetics) {
            if (ownedCosmetic.getId() == cosmeticId) {
                return ownedCosmetic;
            }
        }

        return null;
    }

    public boolean isOwningCosmetic(int cosmeticId) {
        CosmeticInDatabase ownedCosmetic = getOwnedCosmetic(cosmeticId);
        return ownedCosmetic != null;
    }

    public boolean isActiveCosmetic(Cosmetic cosmetic) {
        for (CosmeticHandler<?> cosmeticHandler : activeCosmetics.values()) {
            if (cosmetic.equals(cosmeticHandler.getCosmetic())) {
                return true;
            }
        }
        return false;
    }

    public Collection<CosmeticHandler<?>> getHandlers() {
        return activeCosmetics.values();
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isInDatabase() {
        return isInDatabase;
    }

    public HyperiorCosmetic getHyperiorCosmetic() {
        return hyperiorCosmetic;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
