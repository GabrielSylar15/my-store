package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductDetailResponseDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantUpdate;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantUpdateDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;

public class ProductVariantUpdateImpl implements ProductVariantUpdate {
    private final ProductVariantRepository productVariantRepository;

    public ProductVariantUpdateImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public ProductDetailResponseDTO updateProductVariant(ProductVariantUpdateDTO productVariantUpdateDTO) {
        return null;
    }
}
