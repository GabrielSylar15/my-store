package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantId;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductVariantRepositoryImpl implements ProductVariantRepository {
    private final JPAProductVariantRepository jpaProductVariantRepository;

    @Override
    public void delete(ProductVariant data) {

    }

    @Override
    public List<ProductVariant> findAll() {
        return List.of();
    }

    @Override
    public ProductVariant save(ProductVariant data) {
        return null;
    }

    @Override
    public ProductVariant findById(ProductVariantId productVariantId) {
        return null;
    }

    @Override
    public List<ProductVariant> saveAll(Iterable<ProductVariant> data) {
        return List.of();
    }
}
