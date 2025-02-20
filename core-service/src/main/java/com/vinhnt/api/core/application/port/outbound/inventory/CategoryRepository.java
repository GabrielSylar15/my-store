package com.vinhnt.api.core.application.port.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

import java.util.List;

public interface CategoryRepository extends BaseRepository<Category, Long> {
    List<Category> findByParentIdAndStatus(Long parentId, CategoryStatus status);

    Category findFirstByIdAndStatus(Long id, CategoryStatus status);

}
