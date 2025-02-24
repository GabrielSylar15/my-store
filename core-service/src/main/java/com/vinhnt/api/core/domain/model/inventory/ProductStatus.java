package com.vinhnt.api.core.domain.model.inventory;

public enum ProductStatus {
    ACTIVE(1),
    INACTIVE(2),
    DELETED(3),
    FOR_RETAIL(4),
    FOR_WHOLESALE(5);

    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public static ProductStatus ofProductStatus(int value) {
        return switch (value) {
            case 1 -> ACTIVE;
            case 2 -> INACTIVE;
            case 3 -> DELETED;
            case 4 -> FOR_RETAIL;
            case 5 -> FOR_WHOLESALE;
            default -> throw new IllegalArgumentException("Unexpected value: " + value);
        };
    }

    public int getValue() {
        return value;
    }

}
