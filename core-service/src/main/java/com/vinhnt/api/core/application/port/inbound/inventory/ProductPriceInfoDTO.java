package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.ProductPriceInfo;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductPriceInfoDTO(String currency, Long currentPrice, Long originalPrice) {
    public static ProductPriceInfoDTO fromProductPriceInfo(ProductPriceInfo productPriceInfo) {
        return new ProductPriceInfoDTO(productPriceInfo.currency(), productPriceInfo.currentPrice(), null);
    }

    public ProductPriceInfo toProductPriceInfo() {
        return new ProductPriceInfo(currency, currentPrice, originalPrice);
    }
}
