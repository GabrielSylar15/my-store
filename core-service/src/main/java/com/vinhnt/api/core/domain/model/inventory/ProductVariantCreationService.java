package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.application.port.oubound.product.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.List;

public class ProductVariantCreationService {
    private final ProductVariantRepository productVariantRepository;
    private final ProductRepository productRepository;

    public ProductVariantCreationService(ProductVariantRepository productVariantRepository, ProductRepository productRepository) {
        this.productVariantRepository = productVariantRepository;
        this.productRepository = productRepository;
    }

    public ProductVariant initProductVariant(List<TierVariation> tierVariation,
                                             ProductId productId,
                                             ProductPriceInfo priceInfo,
                                             ProductVariantStatus status,
                                             int stockQuantity,
                                             String sku,
                                             long sold,
                                             int[] tierIndex) throws InvalidProductVariantException {
        ProductVariant productVariant = new ProductVariant(null, productId, priceInfo, status, stockQuantity, sku, sold, tierIndex);
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        productVariant.validate(productRepository, notificationHandler, tierVariation);
        if (notificationHandler.messages().isEmpty()) {
            return productVariant;
        } else {
            throw new InvalidProductVariantException(String.format("Invalid product variant. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }

    public List<ProductVariant> initProductVariants(ProductVariantRepository productVariantRepository) throws InvalidProductVariantException {

    }
}
