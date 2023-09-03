package de.groodian.hyperiorcosmetics.cosmetic.suit;

import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClassicSuitHandler extends CosmeticHandler<ClassicSuitCosmetic> {

    public ClassicSuitHandler(CosmeticPlayer cosmeticPlayer, ClassicSuitCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
    }

    @Override
    public void onEquip() {
        ItemStack itemStack = cosmetic.getEquipItem().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(cosmetic.getInventoryItem().getItemMeta().displayName());
        itemMeta.lore(cosmetic.getInventoryItem().getItemMeta().lore());
        itemStack.setItemMeta(itemMeta);

        switch (cosmetic.getCategory()) {
            case HELMET -> cosmeticPlayer.getPlayer().getInventory().setHelmet(itemStack);
            case CHEST_PLATE -> cosmeticPlayer.getPlayer().getInventory().setChestplate(itemStack);
            case PANTS -> cosmeticPlayer.getPlayer().getInventory().setLeggings(itemStack);
            case SHOES -> cosmeticPlayer.getPlayer().getInventory().setBoots(itemStack);
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onDisable() {
        switch (cosmetic.getCategory()) {
            case HELMET -> cosmeticPlayer.getPlayer().getInventory().setHelmet(null);
            case CHEST_PLATE -> cosmeticPlayer.getPlayer().getInventory().setChestplate(null);
            case PANTS -> cosmeticPlayer.getPlayer().getInventory().setLeggings(null);
            case SHOES -> cosmeticPlayer.getPlayer().getInventory().setBoots(null);
        }
    }

}
