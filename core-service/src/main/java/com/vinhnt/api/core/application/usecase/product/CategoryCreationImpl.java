package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.product.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.product.CategoryDTO;
import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryCreationService;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryCreationImpl implements CategoryCreation {
    private final CategoryCreationService categoryCreationService;
    private final CategoryRepository categoryRepository;

    public CategoryCreationImpl(CategoryCreationService categoryCreationService, CategoryRepository categoryRepository) {
        this.categoryCreationService = categoryCreationService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) throws InvalidCategoryException {
        Category category = categoryCreationService.initCategory(categoryDTO.name(), categoryDTO.description(), categoryDTO.parentId());
        return categoryRepository.save(category);
    }
}
