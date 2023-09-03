package de.groodian.hyperiorcosmetics;

import java.time.OffsetDateTime;

public class CosmeticInDatabase {

    private final int id;
    private final OffsetDateTime unlockedAt;

    private int duplicates;

    public CosmeticInDatabase(int id, OffsetDateTime unlockedAt, int duplicates) {
        this.id = id;
        this.unlockedAt = unlockedAt;
        this.duplicates = duplicates;
    }

    public int getId() {
        return id;
    }

    public OffsetDateTime getUnlockedAt() {
        return unlockedAt;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(int duplicates) {
        this.duplicates = duplicates;
    }

}
