package com.vinhnt.api.core.application.port.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryId;

public interface CategoryRepository extends BaseRepository<Category, CategoryId> {
}
