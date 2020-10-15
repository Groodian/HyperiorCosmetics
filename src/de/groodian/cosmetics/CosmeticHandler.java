package de.groodian.cosmetics;

public abstract class CosmeticHandler<T extends Cosmetic> {

    protected CosmeticPlayer cosmeticPlayer;
    protected T cosmetic;

    public CosmeticHandler(CosmeticPlayer cosmeticPlayer, T cosmetic) {
        this.cosmeticPlayer = cosmeticPlayer;
        this.cosmetic = cosmetic;
    }

    public abstract void onEquip();

    public abstract void onUpdate();

    public abstract void onDisable();

    public CosmeticPlayer getCosmeticPlayer() {
        return cosmeticPlayer;
    }

    public T getCosmetic() {
        return cosmetic;
    }

}
