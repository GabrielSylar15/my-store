package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProductVariant;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductVariantRepositoryImpl implements ProductVariantRepository {
    private final JPAProductVariantRepository jpaProductVariantRepository;

    @Override
    public List<ProductVariant> findByProductIdAndIdIn(Long productId, List<Long> ids) {
        return List.of();
    }

    @Override
    public void deleteAll(List<ProductVariant> productVariants) {
        List<JPAProductVariant> jpaProductVariants = productVariants.stream().map(this::convertToJPAEntity).toList();
        jpaProductVariantRepository.deleteAll(jpaProductVariants);
    }

    @Override
    public List<ProductVariant> findByProductIdAndStatus(Long productId, ProductVariantStatus status) {
        return jpaProductVariantRepository.findByProductId(productId)
                .stream()
                .map(this::convertToDomainModel)
                .toList();
    }

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
    public ProductVariant findById(Long productVariantId) {
        return null;
    }

    @Override
    public List<ProductVariant> saveAll(Iterable<ProductVariant> data) {
        List<JPAProductVariant> jpaProductVariants = new ArrayList<>();
        for (ProductVariant jpaProductVariant : data) {
            jpaProductVariants.add(convertToJPAEntity(jpaProductVariant));
        }
        jpaProductVariants = jpaProductVariantRepository.saveAll(jpaProductVariants);
        return jpaProductVariants.stream().map(this::convertToDomainModel).toList();
    }

    private JPAProductVariant convertToJPAEntity(ProductVariant productVariant) {
        JPAProductVariant jpaProductVariant = new JPAProductVariant();
        jpaProductVariant.setId(productVariant.getId());
        jpaProductVariant.setProductId(productVariant.getProductId());
        jpaProductVariant.setProductPriceInfo(productVariant.getPriceInfo());
        jpaProductVariant.setStockQuantity(productVariant.getStockQuantity());
        jpaProductVariant.setSold(productVariant.getSold());
        jpaProductVariant.setSku(productVariant.getSku());
        jpaProductVariant.setStatus(productVariant.getStatus());
        jpaProductVariant.setTierIndex(Arrays.stream(productVariant.getTierIndex())
                .boxed()
                .collect(Collectors.toList()));
        jpaProductVariant.setVersion(productVariant.getVersion());
        return jpaProductVariant;
    }

    private ProductVariant convertToDomainModel(JPAProductVariant jpaProductVariant) {
        ProductVariant.ProductVariantMemento productVariantMemento = new ProductVariant.ProductVariantMemento(jpaProductVariant.getId(),
                jpaProductVariant.getProductId(),
                jpaProductVariant.getProductPriceInfo(),
                jpaProductVariant.getStatus(),
                jpaProductVariant.getStockQuantity(),
                jpaProductVariant.getSku(),
                jpaProductVariant.getSold(),
                jpaProductVariant.getVersion(),
                jpaProductVariant.getTierIndex().stream().mapToInt(i -> i).toArray());
        return productVariantMemento.restore();
    }
}
