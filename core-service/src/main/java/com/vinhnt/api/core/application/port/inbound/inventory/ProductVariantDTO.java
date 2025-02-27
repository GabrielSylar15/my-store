package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;

import java.util.Arrays;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductVariantDTO(ProductPriceInfoDTO priceInfo,
                                ProductVariantStatus status,
                                int stockQuantity,
                                String sku,
                                long sold,
                                int[] tierIndex) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariantDTO that = (ProductVariantDTO) o;
        return Objects.deepEquals(tierIndex, that.tierIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(tierIndex));
    }
}
