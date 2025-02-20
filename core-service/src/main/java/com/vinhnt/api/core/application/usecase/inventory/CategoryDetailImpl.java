package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetail;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetailResponseDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

import java.util.List;
import java.util.Objects;

public class CategoryDetailImpl implements CategoryDetail {
    private final CategoryRepository categoryRepository;

    public CategoryDetailImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDetailResponseDTO getCategoryDetail(Long id) {
        CategoryDetailResponseDTO result = new CategoryDetailResponseDTO();
        Category category = categoryRepository.findFirstByIdAndStatus(id, CategoryStatus.ACTIVE);
        if (Objects.isNull(category)) {
            return result;
        }
        result = convert(category);
        List<Category> categories = categoryRepository.findByParentIdAndStatus(category.getId(), CategoryStatus.ACTIVE);
        if (!categories.isEmpty()) {
            List<CategoryDetailResponseDTO> categoryDetailResponseDTOs = categories.stream().map(this::convert).toList();
            result.setChildren(categoryDetailResponseDTOs);
        }
        return result;
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
