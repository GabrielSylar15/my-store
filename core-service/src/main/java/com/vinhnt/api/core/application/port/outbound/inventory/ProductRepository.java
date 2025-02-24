package com.vinhnt.api.core.application.port.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;

public interface ProductRepository extends BaseRepository<Product, Long> {
    Product findAvailableProductById(Long productId);
}
