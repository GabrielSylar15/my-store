package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreationDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetailResponseDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryCreationService;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

import java.util.ArrayList;

public class CategoryCreationImpl implements CategoryCreation {
    private final CategoryCreationService categoryCreationService;
    private final CategoryRepository categoryRepository;

    public CategoryCreationImpl(CategoryCreationService categoryCreationService, CategoryRepository categoryRepository) {
        this.categoryCreationService = categoryCreationService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDetailResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO) throws InvalidCategoryException {
        Category category = categoryCreationService.initCategory(categoryCreationDTO.name(), categoryCreationDTO.description(), categoryCreationDTO.parentId());
        category = categoryRepository.save(category);
        return new CategoryDetailResponseDTO(category.getId(), category.getName(), category.getDescription(), category.getParentId(), new ArrayList<>());
    }
}
