package de.groodian.cosmetics;

public abstract class Cosmetic {

    private CosmeticPlayer cosmeticPlayer;
    private int id;
    private String name;
    private CosmeticType type;
    private int price;
    private boolean owning;
    private boolean activated;

    public Cosmetic(CosmeticPlayer cosmeticPlayer, int id, String name, CosmeticType type, int price, boolean owning, boolean activated) {
        this.cosmeticPlayer = cosmeticPlayer;
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.owning = owning;
        this.activated = activated;
    }

    public void activate() {
        CosmeticMySQL.activate(cosmeticPlayer.get);
        onActivation();
    }

    protected abstract void onActivation();

    protected abstract void onUpdate();

    protected abstract void onDeactivation();

    public CosmeticPlayer getCosmeticPlayer() {
        return cosmeticPlayer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CosmeticType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isOwning() {
        return owning;
    }

    public boolean isActivated() {
        return activated;
    }

}
