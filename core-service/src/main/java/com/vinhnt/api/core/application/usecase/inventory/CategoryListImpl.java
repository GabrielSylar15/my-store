package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetailResponseDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryList;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

import java.util.ArrayList;
import java.util.List;

public class CategoryListImpl implements CategoryList {
    private final CategoryRepository categoryRepository;

    public CategoryListImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDetailResponseDTO> getAllCategoryParents() {
        List<Category> parents = categoryRepository.findByParentIdAndStatus(null, CategoryStatus.ACTIVE);
        if (parents.isEmpty()) {
            return new ArrayList<>();
        }
        return parents.stream().map(this::convert).toList();
    }

    private CategoryDetailResponseDTO convert(Category category) {
        CategoryDetailResponseDTO result = new CategoryDetailResponseDTO();
        result.setId(category.getId());
        result.setName(category.getName());
        result.setParentId(category.getParentId());
        result.setDescription(category.getDescription());
        return result;
    }

}
