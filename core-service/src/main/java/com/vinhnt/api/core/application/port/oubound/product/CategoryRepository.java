package com.vinhnt.api.core.application.port.oubound.product;

import com.vinhnt.api.core.application.port.oubound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryId;

public interface CategoryRepository extends BaseRepository<Category, CategoryId> {
}
