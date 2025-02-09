package com.vinhnt.applicationservice.adapter.outbound.product.persistence;

import com.vinhnt.api.core.domain.model.inventory.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProductRepository extends JpaRepository<Product, Long> {
}
