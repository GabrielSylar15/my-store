package com.vinhnt.api.core.application.port.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;

import java.util.List;

public interface ProductVariantRepository extends BaseRepository<ProductVariant, Long> {
    List<ProductVariant> findByProductIdAndStatus(Long productId, ProductVariantStatus status);

    void deleteAll(List<ProductVariant> productVariants);

    List<ProductVariant> findByProductIdAndIdIn(Long productId, List<Long> ids);
}
