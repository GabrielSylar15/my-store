package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.product.ProductVariantCreation;
import com.vinhnt.api.core.application.port.inbound.product.ProductVariantCreationDTO;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;

import java.util.List;

public class ProductVariantCreationImpl implements ProductVariantCreation {
    @Override
    public List<ProductVariant> createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) {
        return null;
    }
}
