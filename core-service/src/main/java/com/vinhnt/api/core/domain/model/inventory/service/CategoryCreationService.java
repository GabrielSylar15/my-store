package com.vinhnt.api.core.domain.model.inventory.service;

import com.vinhnt.api.core.application.port.inbound.product.CategoryDTO;
import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

public class CategoryCreationService {
    private final CategoryRepository categoryRepository;

    public CategoryCreationService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category("", "", 1L, CategoryStatus.ACTIVE);
    }
}
