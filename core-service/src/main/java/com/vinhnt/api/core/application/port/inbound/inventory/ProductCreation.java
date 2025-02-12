package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;

public interface ProductCreation {
    Product createProduct(ProductCreationDTO productCreationDTO) throws InvalidProductException;
}
