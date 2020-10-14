package de.groodian.cosmetics.trails.armor;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassicArmor {

    public static void run() {
        for (Map.Entry<Player, String> current : Main.helmet.entrySet()) {
            if (current.getValue().equals(TrailsNames.LEATHER_HELMET_NAME))
                current.getKey().getInventory().setHelmet(new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.LEATHER_HELMET_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.CHAINMAIL_HELMET_NAME))
                current.getKey().getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET).setName(TrailsNames.CHAINMAIL_HELMET_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.GOLD_HELMET_NAME))
                current.getKey().getInventory().setHelmet(new ItemBuilder(Material.GOLD_HELMET).setName(TrailsNames.GOLD_HELMET_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.DIAMOND_HELMET_NAME))
                current.getKey().getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).setName(TrailsNames.DIAMOND_HELMET_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());
        }

        for (Map.Entry<Player, String> current : Main.chestplate.entrySet()) {
            if (current.getValue().equals(TrailsNames.LEATHER_CHESTPLATE_NAME))
                current.getKey().getInventory().setChestplate(new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.LEATHER_CHESTPLATE_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.CHAINMAIL_CHESTPLATE_NAME))
                current.getKey().getInventory().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName(TrailsNames.CHAINMAIL_CHESTPLATE_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.GOLD_CHESTPLATE_NAME))
                current.getKey().getInventory().setChestplate(new ItemBuilder(Material.GOLD_CHESTPLATE).setName(TrailsNames.GOLD_CHESTPLATE_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.DIAMOND_CHESTPLATE_NAME))
                current.getKey().getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName(TrailsNames.DIAMOND_CHESTPLATE_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());

        }

        for (Map.Entry<Player, String> current : Main.pants.entrySet()) {
            if (current.getValue().equals(TrailsNames.LEATHER_PANTS_NAME))
                current.getKey().getInventory().setLeggings(new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.LEATHER_PANTS_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.CHAINMAIL_PANTS_NAME))
                current.getKey().getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setName(TrailsNames.CHAINMAIL_PANTS_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.GOLD_PANTS_NAME))
                current.getKey().getInventory().setLeggings(new ItemBuilder(Material.GOLD_LEGGINGS).setName(TrailsNames.GOLD_PANTS_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.DIAMOND_PANTS_NAME))
                current.getKey().getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).setName(TrailsNames.DIAMOND_PANTS_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());
        }

        for (Map.Entry<Player, String> current : Main.shoes.entrySet()) {
            if (current.getValue().equals(TrailsNames.LEATHER_SHOES_NAME))
                current.getKey().getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.LEATHER_SHOES_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.CHAINMAIL_SHOES_NAME))
                current.getKey().getInventory().setBoots(new ItemBuilder(Material.CHAINMAIL_BOOTS).setName(TrailsNames.CHAINMAIL_SHOES_NAME).setLore("?7Seltenheit: ?7Gew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.GOLD_SHOES_NAME))
                current.getKey().getInventory().setBoots(new ItemBuilder(Material.GOLD_BOOTS).setName(TrailsNames.GOLD_SHOES_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());

            else if (current.getValue().equals(TrailsNames.DIAMOND_SHOES_NAME))
                current.getKey().getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).setName(TrailsNames.DIAMOND_SHOES_NAME).setLore("?7Seltenheit: ?aUngew?hnlich").build());
        }

    }

}