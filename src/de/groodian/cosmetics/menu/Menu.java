package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class Menu implements Listener {

    protected HyperiorCosmetic hyperiorCosmetic;
    protected String title;
    protected int size;

    public Menu(HyperiorCosmetic hyperiorCosmetic, String title, int size) {
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.title = title;
        this.size = size;

        hyperiorCosmetic.getServer().getPluginManager().registerEvents(this, hyperiorCosmetic);
    }

    public void open(CosmeticPlayer cosmeticPlayer) {
        Inventory inventory = Bukkit.createInventory(null, size, title);
        putItems(cosmeticPlayer, inventory);
        cosmeticPlayer.getPlayer().openInventory(inventory);
    }

    protected abstract void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory);

    @EventHandler
    public void handleInventoryClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory() == null)
            return;

        if (e.getClickedInventory().getTitle() == null)
            return;

        if (!e.getClickedInventory().getTitle().equals(title))
            return;

        if (e.getCurrentItem() == null)
            return;

        if (e.getCurrentItem().getItemMeta() == null)
            return;

        if (e.getCurrentItem().getItemMeta().getDisplayName() == null)
            return;

        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(player);
        handleClick(new ClickData(cosmeticPlayer, e.getInventory(), e.getAction(), e.getCurrentItem(), e.getSlot()));
    }

    public abstract void handleClick(ClickData clickData);

}
