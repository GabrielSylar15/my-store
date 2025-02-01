package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.ProductVariantRepository;

public class ProductVariantCreationService {
    private final ProductVariantRepository productVariantRepository;

    public ProductVariantCreationService(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    public ProductVariant initProductVariant(ProductId productId,
                                             ProductPriceInfo priceInfo,
                                             ProductVariantStatus status,
                                             int stockQuantity,
                                             String sku,
                                             long sold,
                                             int[] tierIndex) {
        ProductVariant productVariant = new ProductVariant(null, productId, priceInfo, status, stockQuantity, sku, sold, tierIndex);
        return productVariant;
    }
}
