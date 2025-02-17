package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProductRepository extends JpaRepository<JPAProduct, Long> {
}
