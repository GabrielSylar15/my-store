package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.AggregateRoot;


public class ProductVariant implements AggregateRoot<ProductVariantId> {
    private ProductVariantId Id;
    private ProductId productId;
    private ProductPriceInfo priceInfo;
    private ProductVariantStatus status;
    private int stockQuantity;
    private String sku;
    private long sold;
    private int[] tierIndex;

    ProductVariant(ProductVariantId id, ProductId productId, ProductPriceInfo priceInfo, ProductVariantStatus status, int stockQuantity, String sku, long sold, int[] tierIndex) {
        Id = id;
        this.priceInfo = priceInfo;
        this.productId = productId;
        this.sku = sku;
        this.sold = sold;
        this.status = status;
        this.stockQuantity = stockQuantity;
        this.tierIndex = tierIndex;
    }
}
