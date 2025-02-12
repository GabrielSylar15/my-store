package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public interface CategoryCreation {
    Category createCategory(CategoryCreationDTO categoryCreationDTO) throws InvalidCategoryException;
}

