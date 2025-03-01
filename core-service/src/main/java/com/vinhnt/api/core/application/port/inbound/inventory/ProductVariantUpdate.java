package com.vinhnt.api.core.application.port.inbound.inventory;

public interface ProductVariantUpdate {
    ProductVariantCreationOutputDTO updateProductVariant(ProductVariantUpdateDTO productVariantUpdateDTO);
}
