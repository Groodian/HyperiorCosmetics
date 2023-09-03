package de.groodian.hyperiorcosmetics.menu;

import de.groodian.hyperiorcore.gui.GUI;
import de.groodian.hyperiorcore.util.ItemBuilder;
import de.groodian.hyperiorcosmetics.HyperiorCosmetic;
import de.groodian.hyperiorcosmetics.player.CosmeticPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;

public class MainMenu extends GUI {

    private final HyperiorCosmetic hyperiorCosmetic;
    private final CosmeticPlayer cosmeticPlayer;

    public MainMenu(HyperiorCosmetic hyperiorCosmetic, CosmeticPlayer cosmeticPlayer) {
        super(Component.text("Kosmetik"), 54);
        this.hyperiorCosmetic = hyperiorCosmetic;
        this.cosmeticPlayer = cosmeticPlayer;
    }

    @Override
    protected void onOpen() {
        putItem(new ItemBuilder(Material.BARRIER).setName(Component.text("Deaktiviere alle Kosmetik", NamedTextColor.RED)).build(), 49,
                cosmeticPlayer::disableAll);

        putMenuCategory(Material.REDSTONE, "Partikel", 11,
                new DefaultCosmeticMenu(hyperiorCosmetic, HyperiorCosmetic.PARTICLE_COLLECTION, cosmeticPlayer, 1));
        putMenuCategory(Material.GOLD_BLOCK, "Blockspuren", 15,
                new DefaultCosmeticMenu(hyperiorCosmetic, HyperiorCosmetic.BLOCK_COLLECTION, cosmeticPlayer, 1));
        putMenuCategory(Material.DIAMOND_CHESTPLATE, "Anzüge", 29,
                new SuitMenu(hyperiorCosmetic, HyperiorCosmetic.SUIT_COLLECTION, cosmeticPlayer, 1));
        putMenuCategory(Material.COMPARATOR, "Gadgets", 33,
                new DefaultCosmeticMenu(hyperiorCosmetic, HyperiorCosmetic.GADGET_COLLECTION, cosmeticPlayer, 1));
    }

    private void putMenuCategory(Material material, String name, int slot, CosmeticMenu cosmeticMenu) {
        putItem(new ItemBuilder(material).setName(Component.text(name, NamedTextColor.GREEN)).build(), slot,
                () -> hyperiorCosmetic.getCosmeticsGUIManager().open(player, cosmeticMenu));
    }

    @Override
    public void onUpdate() {
    }

}
