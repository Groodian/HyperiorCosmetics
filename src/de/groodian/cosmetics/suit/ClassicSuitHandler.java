package de.groodian.cosmetics.suit;

import de.groodian.cosmetics.CosmeticHandler;
import de.groodian.cosmetics.CosmeticPlayer;
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
        itemMeta.setDisplayName(cosmetic.getRarity().getColor() + cosmetic.getName());
        itemStack.setItemMeta(itemMeta);

        switch (cosmetic.getCategory()) {
            case HELMET:
                cosmeticPlayer.getPlayer().getInventory().setHelmet(itemStack);
                break;
            case CHEST_PLATE:
                cosmeticPlayer.getPlayer().getInventory().setChestplate(itemStack);
                break;
            case PANTS:
                cosmeticPlayer.getPlayer().getInventory().setLeggings(itemStack);
                break;
            case SHOES:
                cosmeticPlayer.getPlayer().getInventory().setBoots(itemStack);
                break;
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onDisable() {
        switch (cosmetic.getCategory()) {
            case HELMET:
                cosmeticPlayer.getPlayer().getInventory().setHelmet(null);
                break;
            case CHEST_PLATE:
                cosmeticPlayer.getPlayer().getInventory().setChestplate(null);
                break;
            case PANTS:
                cosmeticPlayer.getPlayer().getInventory().setLeggings(null);
                break;
            case SHOES:
                cosmeticPlayer.getPlayer().getInventory().setBoots(null);
                break;
        }
    }

}
