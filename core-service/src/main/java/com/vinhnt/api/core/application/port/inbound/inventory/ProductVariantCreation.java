package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

public interface ProductVariantCreation {
    ProductVariantCreationOutputDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) throws InvalidProductVariantException, InvalidProductException;
}
