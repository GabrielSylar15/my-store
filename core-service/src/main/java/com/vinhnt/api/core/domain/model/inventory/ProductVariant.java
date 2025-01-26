package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.Entity;

import java.util.List;

public class ProductVariant implements AggregateRoot<ProductVariantId> {
    private ProductVariantId Id;
    private ProductId productId;
    private ProductPriceInfo priceInfo;
    private List<ProductAttribute> attributes;
    private ProductVariantStatus status;
    private int stockQuantity;
}
