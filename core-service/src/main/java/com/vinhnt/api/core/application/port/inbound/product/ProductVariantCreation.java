package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.ProductVariant;

import java.util.List;

public interface ProductVariantCreation {
    List<ProductVariant> createProductVariant(ProductVariantCreationDTO productVariantCreationDTO);
}
