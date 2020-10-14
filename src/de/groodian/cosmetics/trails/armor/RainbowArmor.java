package de.groodian.cosmetics.trails.armor;

import de.groodian.cosmetics.main.Main;
import de.groodian.cosmetics.trails.TrailsNames;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Random;

public class RainbowArmor {

    private static HashMap<Player, Triplet> colors = new HashMap<Player, Triplet>();

    public static void run() {
        for (Player use : Bukkit.getOnlinePlayers()) {
            colors.put(use, new Triplet(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            if (Main.helmet.containsKey(use)) {
                if (Main.helmet.get(use).equals(TrailsNames.RAINBOW_HELMET_NAME)) {
                    use.getInventory().setHelmet(new ItemBuilder(Material.LEATHER_HELMET).setName(TrailsNames.RAINBOW_HELMET_NAME).setLore("?7Seltenheit: ?dEpisch").setColorAndBuild(colors.get(use).a, colors.get(use).b, colors.get(use).c));
                }
            }
            if (Main.chestplate.containsKey(use)) {
                if (Main.chestplate.get(use).equals(TrailsNames.RAINBOW_CHESTPLATE_NAME)) {
                    use.getInventory().setChestplate(new ItemBuilder(Material.LEATHER_CHESTPLATE).setName(TrailsNames.RAINBOW_CHESTPLATE_NAME).setLore("?7Seltenheit: ?dEpisch").setColorAndBuild(colors.get(use).a, colors.get(use).b, colors.get(use).c));
                }
            }
            if (Main.pants.containsKey(use)) {
                if (Main.pants.get(use).equals(TrailsNames.RAINBOW_PANTS_NAME)) {
                    use.getInventory().setLeggings(new ItemBuilder(Material.LEATHER_LEGGINGS).setName(TrailsNames.RAINBOW_PANTS_NAME).setLore("?7Seltenheit: ?dEpisch").setColorAndBuild(colors.get(use).a, colors.get(use).b, colors.get(use).c));
                }
            }
            if (Main.shoes.containsKey(use)) {
                if (Main.shoes.get(use).equals(TrailsNames.RAINBOW_SHOES_NAME)) {
                    use.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).setName(TrailsNames.RAINBOW_SHOES_NAME).setLore("?7Seltenheit: ?dEpisch").setColorAndBuild(colors.get(use).a, colors.get(use).b, colors.get(use).c));
                }
            }
        }
    }

}
