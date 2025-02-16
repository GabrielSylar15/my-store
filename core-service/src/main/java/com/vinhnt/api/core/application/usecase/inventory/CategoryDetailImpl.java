package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetail;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetailResponseDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;

public class CategoryDetailImpl implements CategoryDetail {
    private final CategoryRepository categoryRepository;

    public CategoryDetailImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDetailResponseDTO getCategoryDetail(Long id) {
        return null;
    }
}
