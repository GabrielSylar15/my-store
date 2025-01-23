package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.inbound.product.CategoryDTO;
import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryCreationService {
    private final CategoryRepository categoryRepository;

    public CategoryCreationService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category initCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.name(), categoryDTO.description(), categoryDTO.parentId(), CategoryStatus.ACTIVE);
        CategoryValidationNotificationHandler notificationHandler = new CategoryValidationNotificationHandler();
        category.validate(categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return category;
        } else {
            throw new InvalidCategoryException(String.format("Invalid category. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }
}
