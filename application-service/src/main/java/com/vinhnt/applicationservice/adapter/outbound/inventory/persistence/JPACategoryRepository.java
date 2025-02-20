package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPACategoryRepository extends JpaRepository<JPACategory, Long> {
    List<JPACategory> findByParentIdAndStatus(Long parentId, CategoryStatus status);

    JPACategory findFirstByIdAndStatus(Long id, CategoryStatus status);
}
