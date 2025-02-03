package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.ProductId;
import com.vinhnt.api.core.domain.model.inventory.ProductPriceInfo;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;

public record ProductVariantDTO(ProductPriceInfo priceInfo,
                                ProductVariantStatus status,
                                int stockQuantity,
                                String sku,
                                long sold,
                                int[] tierIndex) {
}
