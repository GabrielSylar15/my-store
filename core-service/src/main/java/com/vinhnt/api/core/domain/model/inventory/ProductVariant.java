package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;


public class ProductVariant implements AggregateRoot<ProductVariantId> {
    private ProductVariantId id;
    private ProductId productId;
    private ProductPriceInfo priceInfo;
    private ProductVariantStatus status;
    private int stockQuantity;
    private String sku;
    private long sold;
    private int[] tierIndex;

    ProductVariant(ProductVariantId id, ProductId productId, ProductPriceInfo priceInfo, ProductVariantStatus status, int stockQuantity, String sku, long sold, int[] tierIndex) {
        this.id = id;
        this.priceInfo = priceInfo;
        this.productId = productId;
        this.sku = sku;
        this.sold = sold;
        this.status = status;
        this.stockQuantity = stockQuantity;
        this.tierIndex = tierIndex;
    }

    public void validate(ProductRepository productRepository, ValidationNotificationHandler validationNotificationHandler) {

    }

}
