package de.groodian.cosmetics.menu;

import de.groodian.cosmetics.CosmeticPlayer;
import de.groodian.cosmetics.HyperiorCosmetic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu implements Listener {

    protected HyperiorCosmetic hyperiorCosmetic;
    protected String title;
    protected int size;

    private Map<Inventory, Map<ItemStack, MenuRunnable>> menuRunnableMap;

    public Menu(HyperiorCosmetic hyperiorCosmetic, String title, int size) {
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.title = title;
        this.size = size;

        menuRunnableMap = new HashMap<>();
        hyperiorCosmetic.getServer().getPluginManager().registerEvents(this, hyperiorCosmetic);
    }

    public void open(CosmeticPlayer cosmeticPlayer) {
        open(cosmeticPlayer, 1);
    }

    public void open(CosmeticPlayer cosmeticPlayer, int page) {
        Inventory inventory = Bukkit.createInventory(null, size, title);
        putItems(cosmeticPlayer, inventory, page);
        cosmeticPlayer.getPlayer().openInventory(inventory);
    }

    protected abstract void putItems(CosmeticPlayer cosmeticPlayer, Inventory inventory, int page);

    protected void putItem(Inventory inventory, ItemStack itemStack, int slot, MenuRunnable menuRunnable) {
        if (menuRunnableMap.containsKey(inventory)) {
            Map<ItemStack, MenuRunnable> map = menuRunnableMap.get(inventory);
            map.put(itemStack, menuRunnable);
        } else {
            Bukkit.broadcastMessage("Created Inventory");
            Map<ItemStack, MenuRunnable> map = new HashMap<>();
            map.put(itemStack, menuRunnable);
            menuRunnableMap.put(inventory, map);
        }
        inventory.setItem(slot, itemStack);
    }

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

        if (!menuRunnableMap.containsKey(e.getInventory()))
            return;

        if (!menuRunnableMap.get(e.getInventory()).containsKey(e.getCurrentItem()))
            return;

        if (menuRunnableMap.get(e.getInventory()).get(e.getCurrentItem()) == null)
            return;

        CosmeticPlayer cosmeticPlayer = hyperiorCosmetic.getCosmeticPlayerManager().getCosmeticPlayer(player);
        ClickData clickData = new ClickData(cosmeticPlayer, e.getInventory(), e.getAction(), e.getCurrentItem(), e.getSlot());
        menuRunnableMap.get(e.getInventory()).get(e.getCurrentItem()).run(clickData);
    }

    @EventHandler
    public void handleInventoryClose(InventoryCloseEvent e) {
        if (menuRunnableMap.containsKey(e.getInventory())) {
            menuRunnableMap.remove(e.getInventory());
            Bukkit.broadcastMessage("Removed Inventory");
        }
    }

    protected boolean compareItemNames(ItemStack itemStack0, ItemStack itemStack1) {
        return itemStack0.getItemMeta().getDisplayName().equals(itemStack1.getItemMeta().getDisplayName());
    }

}
