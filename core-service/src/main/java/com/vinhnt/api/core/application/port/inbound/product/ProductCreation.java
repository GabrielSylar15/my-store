package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.Product;

public interface ProductCreation {
    Product createProduct(ProductCreationDTO productCreationDTO);
}
