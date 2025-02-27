package com.vinhnt.api.core.domain.model.inventory;

public enum ProductVariantStatus {
    AVAILABLE(1),
    UNAVAILABLE(0);

    private final int value;

    ProductVariantStatus(int value) {
        this.value = value;
    }

    public static ProductVariantStatus getProductVariantStatus(int value) {
        return switch (value) {
            case 1 -> AVAILABLE;
            case 0 -> UNAVAILABLE;
            default -> null;
        };
    }

    public int getValue() {
        return value;
    }

}
