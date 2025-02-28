package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAProductVariantRepository extends JpaRepository<JPAProductVariant, Long> {
    List<JPAProductVariant> findByProductId(Long productId);
}
