package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcore.gui.GUIRunnable;
import de.groodian.hyperiorcore.main.HyperiorCore;
import de.groodian.hyperiorcore.user.CoinSystem;
import de.groodian.hyperiorcore.user.User;
import de.groodian.hyperiorcore.util.HSound;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcore.util.Time;
import de.groodian.hyperiorcosmetics.CosmeticInDatabase;
import de.groodian.hyperiorcosmetics.CosmeticsDatabase;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.cosmetic.Category;
import de.groodian.hyperiorcosmetics.cosmetic.Cosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class CosmeticMenu extends GUI {

    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    protected final HyperiorCosmetic hyperiorCosmetic;
    protected final CosmeticPlayer cosmeticPlayer;
    protected final int page;
    private final Category[] deactivateCategories;
    private final ItemStack deactivateItem;

    public CosmeticMenu(HyperiorCosmetic hyperiorCosmetic, String name, CosmeticPlayer cosmeticPlayer, int page,
                        Category... deactivateCategories) {
        super(Component.text("Kosmetik > " + name), 54);
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.cosmeticPlayer = cosmeticPlayer;
        this.page = page;
        this.deactivateCategories = deactivateCategories;

        deactivateItem = new ItemBuilder(Material.BARRIER).setName(Component.text("Deaktiviere " + name, NamedTextColor.RED)).build();
    }

    @Override
    protected void onOpen() {
        ItemStack animationItem = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(Component.empty()).build();
        putItemDelayed(animationItem, 36, 2);
        putItemDelayed(animationItem, 37, 3);
        putItemDelayed(animationItem, 38, 4);
        putItemDelayed(animationItem, 39, 5);
        putItemDelayed(animationItem, 40, 6);
        putItemDelayed(animationItem, 41, 7);
        putItemDelayed(animationItem, 42, 8);
        putItemDelayed(animationItem, 43, 9);
        putItemDelayed(animationItem, 44, 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                String previousPage = String.valueOf(page - 1);
                GUIRunnable previousRunnable = () -> hyperiorCosmetic.getCosmeticsGUIManager().open(player, newGUIForPage(page - 1));
                if (page - 1 <= 0) {
                    previousPage = "-";
                    previousRunnable = null;
                }
                putItem(new ItemBuilder(Material.REDSTONE)
                                .setName(Component.text("Zurück", NamedTextColor.RED))
                                .build(), 45,
                        () -> hyperiorCosmetic.getCosmeticsGUIManager().open(player, new MainMenu(hyperiorCosmetic, cosmeticPlayer)));
                putItem(new ItemBuilder(Material.ARROW)
                        .setName(Component.text("Vorherige Seite", NamedTextColor.GREEN))
                        .setLore(Component.text("Seite " + previousPage, NamedTextColor.GRAY))
                        .build(), 48, previousRunnable);
                putItem(deactivateItem, 49, () -> {
                    for (Category category : deactivateCategories) {
                        cosmeticPlayer.disableCosmetic(category);
                    }
                    setCosmetics();
                });
                putItem(new ItemBuilder(Material.ARROW)
                        .setName(Component.text("Nächste Seite", NamedTextColor.GREEN))
                        .setLore(Component.text("Seite " + (page + 1), NamedTextColor.GRAY))
                        .build(), 50, () -> hyperiorCosmetic.getCosmeticsGUIManager().open(player, newGUIForPage(page + 1)));

                setCosmetics();
            }
        }.runTaskLater(hyperiorCosmetic, 8);

        new HSound(Sound.ENTITY_HORSE_SADDLE).playFor(cosmeticPlayer.getPlayer());
    }

    @Override
    public void onUpdate() {
    }

    protected abstract void setCosmetics();

    protected abstract GUI newGUIForPage(int page);

    protected void putCosmetic(Cosmetic cosmetic, int slot) {
        GUIRunnable guiRunnable = null;
        ItemBuilder itemBuilder = new ItemBuilder(cosmetic.getInventoryItem().clone());
        itemBuilder.addLore(Component.empty());

        if (cosmeticPlayer.isOwningCosmetic(cosmetic.getId())) {
            itemBuilder.addGlow();

            CosmeticInDatabase ownedCosmetic = cosmeticPlayer.getOwnedCosmetic(cosmetic.getId());
            itemBuilder.addLore(
                    Component.text("Freigeschaltet am: " + Time.formatDate(ownedCosmetic.getUnlockedAt()), NamedTextColor.GRAY));
            itemBuilder.addLore(Component.text("Duplikate erhalten: " + ownedCosmetic.getDuplicates(), NamedTextColor.GRAY));
            itemBuilder.addLore(Component.empty());

            if (cosmeticPlayer.isActiveCosmetic(cosmetic)) {
                itemBuilder.addLore(Component.text("Klicke zum Deaktivieren", NamedTextColor.RED));
                guiRunnable = () -> {
                    cosmeticPlayer.disableCosmetic(cosmetic.getCategory());
                    setCosmetics();
                    new HSound(Sound.UI_BUTTON_CLICK).playFor(player);
                };
            } else {
                itemBuilder.addLore(Component.text("Klicke zum Aktivieren", NamedTextColor.GREEN));
                guiRunnable = () -> {
                    cosmeticPlayer.equip(cosmetic);
                    setCosmetics();
                    new HSound(Sound.UI_BUTTON_CLICK).playFor(player);
                };
            }
        } else {
            itemBuilder.addLore(Component.text("Du besitzt diesen Gegenstand noch nicht!", NamedTextColor.RED));
            User user = HyperiorCore.getPaper().getUserManager().get(cosmeticPlayer.getUuid());
            if (user == null) {
                return;
            }

            if (user.has("cosmetics.buy")) {
                int coins = user.getCoins();
                if (coins < cosmetic.getPrice()) {
                    itemBuilder.addLore(Component.text("Dir fehlen ", NamedTextColor.RED)
                            .append(Component.text((cosmetic.getPrice() - coins) + " Coins", NamedTextColor.YELLOW))
                            .append(Component.text(" um", NamedTextColor.RED)));
                    itemBuilder.addLore(Component.text("den Gegenstand zu kaufen.", NamedTextColor.RED));
                } else {
                    itemBuilder.addLore(Component.text("Klicke um den Gegenstand", NamedTextColor.GREEN));
                    itemBuilder.addLore(Component.text("für ", NamedTextColor.GREEN)
                            .append(Component.text(cosmetic.getPrice() + " Coins", NamedTextColor.YELLOW))
                            .append(Component.text(" zu kaufen.", NamedTextColor.GREEN)));

                    guiRunnable = () -> {
                        HyperiorCore.getPaper().getDatabaseManager().transaction(List.of(
                                new CoinSystem.Remove(cosmetic.getPrice(), player),
                                new CosmeticsDatabase.Add(cosmeticPlayer, new CosmeticInDatabase(cosmetic.getId(), OffsetDateTime.now(), 0))
                        ), success -> {
                            if (success) {
                                setCosmetics();
                                new HSound(Sound.ENTITY_PLAYER_LEVELUP).playFor(player);
                            }
                        });
                    };
                }
            } else {
                itemBuilder.addLore(Component.text("Du kannst den Gegenstand mit", NamedTextColor.GRAY));
                itemBuilder.addLore(Component.text("dem", NamedTextColor.GRAY)
                        .append(Component.text(" VIP-Rang", NamedTextColor.YELLOW))
                        .append(Component.text(" kaufen.", NamedTextColor.GRAY)));
            }
        }

        putItem(itemBuilder.build(), slot, guiRunnable, Duration.ofSeconds(4));
    }

}
