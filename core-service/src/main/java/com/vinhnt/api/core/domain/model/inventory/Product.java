package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.AggregateRoot;

import java.util.List;

public class Product implements AggregateRoot<ProductId> {
    private ProductId id;
    private String name;
    private String description;
    private Category category;
    private List<ProductVariant> productVariants;
}
