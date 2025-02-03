package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class ProductPriceInfo implements ValueObject {
    private final String currency;
    private final long currentPrice;
    private final long originalPrice;

    ProductPriceInfo(String currency, long currentPrice, long originalPrice) {
        this.currency = currency;
        this.currentPrice = currentPrice;
        this.originalPrice = originalPrice;
    }

    String getCurrency() {
        return currency;
    }

    long getCurrentPrice() {
        return currentPrice;
    }

    long getOriginalPrice() {
        return originalPrice;
    }
}
