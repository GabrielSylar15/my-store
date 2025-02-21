package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
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
    public Product findById(Long productId) {
        return null;
    }

    @Override
    public List<Product> saveAll(Iterable<Product> data) {
        return List.of();
    }
}
