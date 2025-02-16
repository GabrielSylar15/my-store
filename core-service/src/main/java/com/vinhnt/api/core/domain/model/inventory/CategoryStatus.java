package com.vinhnt.api.core.domain.model.inventory;

public enum CategoryStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int value;

    CategoryStatus(int value) {
        this.value = value;
    }

    public static CategoryStatus ofCategoryStatus(int value) {
        return switch (value) {
            case 1 -> ACTIVE;
            case 0 -> INACTIVE;
            default -> throw new IllegalArgumentException("Unexpected value: " + value);
        };
    }

    public int getValue() {
        return value;
    }

}
