package de.groodian.hyperiorcosmetics.cosmetic.suit;

import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.cosmetic.CosmeticHandler;
import de.groodian.hyperiorcosmetics.cosmetic.DefaultCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DiscoSuitHandler extends CosmeticHandler<DefaultCosmetic> {

    private final Random random;

    public DiscoSuitHandler(CosmeticPlayer cosmeticPlayer, DefaultCosmetic cosmetic) {
        super(cosmeticPlayer, cosmetic);
        random = new Random();
    }

    @Override
    public void onEquip() {
    }

    @Override
    public void onUpdate() {
        ItemStack itemStack = new ItemBuilder(Material.LEATHER_HELMET)
                .setName(cosmetic.getInventoryItem().getItemMeta().displayName())
                .setLore(cosmetic.getInventoryItem().getItemMeta().lore())
                .setLeatherColor(random.nextInt(255), random.nextInt(255), random.nextInt(255))
                .build();

        switch (cosmetic.getCategory()) {
            case HELMET -> {
                itemStack.setType(Material.LEATHER_HELMET);
                cosmeticPlayer.getPlayer().getInventory().setHelmet(itemStack);
            }
            case CHEST_PLATE -> {
                itemStack.setType(Material.LEATHER_CHESTPLATE);
                cosmeticPlayer.getPlayer().getInventory().setChestplate(itemStack);
            }
            case PANTS -> {
                itemStack.setType(Material.LEATHER_LEGGINGS);
                cosmeticPlayer.getPlayer().getInventory().setLeggings(itemStack);
            }
            case SHOES -> {
                itemStack.setType(Material.LEATHER_BOOTS);
                cosmeticPlayer.getPlayer().getInventory().setBoots(itemStack);
            }
        }
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
