package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;


public record ProductPriceInfo(String currency, long currentPrice, long originalPrice) implements ValueObject {
}
