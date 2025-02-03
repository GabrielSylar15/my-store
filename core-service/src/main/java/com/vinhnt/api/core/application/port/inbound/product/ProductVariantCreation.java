package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.List;

public interface ProductVariantCreation {
    ProductVariantCreationOutputDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) throws InvalidProductVariantException, InvalidProductException;
}
