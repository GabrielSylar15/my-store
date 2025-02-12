package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdate;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdateDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryUpdateService;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryUpdateImpl implements CategoryUpdate {
    private final CategoryRepository categoryRepository;
    private final CategoryUpdateService categoryUpdateService;

    public CategoryUpdateImpl(CategoryRepository categoryRepository, CategoryUpdateService categoryUpdateService) {
        this.categoryRepository = categoryRepository;
        this.categoryUpdateService = categoryUpdateService;
    }

    @Override
    public Category updateCategory(CategoryUpdateDTO categoryUpdateDTO) throws InvalidCategoryException {
        Category category = categoryUpdateService.initCategory(categoryUpdateDTO.id(), categoryUpdateDTO.name(), categoryUpdateDTO.description(), categoryUpdateDTO.parentId(), categoryUpdateDTO.status());
        return categoryRepository.save(category);
    }
}
