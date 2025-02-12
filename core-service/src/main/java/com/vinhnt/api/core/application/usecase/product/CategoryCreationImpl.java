package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreationDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
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
    public Category createCategory(CategoryCreationDTO categoryCreationDTO) throws InvalidCategoryException {
        Category category = categoryCreationService.initCategory(categoryCreationDTO.name(), categoryCreationDTO.description(), categoryCreationDTO.parentId());
        return categoryRepository.save(category);
    }
}
