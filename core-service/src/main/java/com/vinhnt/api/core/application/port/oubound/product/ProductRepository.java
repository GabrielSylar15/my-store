package com.vinhnt.api.core.application.port.oubound.product;

import com.vinhnt.api.core.application.port.oubound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductId;

public interface ProductRepository extends BaseRepository<Product, ProductId> {
}
