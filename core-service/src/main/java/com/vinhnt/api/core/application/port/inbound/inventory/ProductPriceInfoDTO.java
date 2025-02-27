package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.ProductPriceInfo;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductPriceInfoDTO(String currency, long currentPrice, long originalPrice) {
    public ProductPriceInfo toProductPriceInfo() {
        return new ProductPriceInfo(currency, currentPrice, originalPrice);
    }
}
