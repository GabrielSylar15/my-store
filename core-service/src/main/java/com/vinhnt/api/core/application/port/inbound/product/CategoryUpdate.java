package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public interface CategoryUpdate {
    Category updateCategory(CategoryUpdateDTO categoryUpdateDTO) throws InvalidCategoryException;
}
