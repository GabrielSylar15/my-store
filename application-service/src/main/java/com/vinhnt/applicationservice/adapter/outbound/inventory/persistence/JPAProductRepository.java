package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import com.vinhnt.api.core.domain.model.inventory.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JPAProductRepository extends JpaRepository<JPAProduct, Long> {
    @Query(value = "SELECT * FROM products WHERE id = :productId and status <> 2", nativeQuery = true)
    Product findAvailableProductById(Long productId);
}
