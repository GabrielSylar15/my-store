package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.ProductVariant;

public interface ProductVariantCreation {
    ProductVariant createProductVariant(ProductVariantCreationDTO productVariantCreationDTO);
}
