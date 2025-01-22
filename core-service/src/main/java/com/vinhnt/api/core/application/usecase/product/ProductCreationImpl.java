package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.product.ProductCreation;
import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.domain.service.product.ProductCreationService;

public class ProductCreationImpl implements ProductCreation {
    private final ProductRepository productRepository;
    private final ProductCreationService productCreationService;

    public ProductCreationImpl(ProductRepository productRepository, ProductCreationService productCreationService) {
        this.productRepository = productRepository;
        this.productCreationService = productCreationService;
    }


}
