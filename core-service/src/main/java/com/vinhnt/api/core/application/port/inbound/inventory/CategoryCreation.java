package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public interface CategoryCreation {
    CategoryDetailResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO) throws InvalidCategoryException;
}

