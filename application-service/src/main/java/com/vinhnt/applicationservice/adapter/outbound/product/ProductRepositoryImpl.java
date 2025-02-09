package com.vinhnt.applicationservice.adapter.outbound.product;

import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void delete(Product data) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product data) {
        return null;
    }

    @Override
    public Product findById(ProductId productId) {
        return null;
    }

    @Override
    public List<Product> saveAll(Iterable<Product> data) {
        return List.of();
    }
}
