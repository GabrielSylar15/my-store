package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryUpdateService {
    private final CategoryRepository categoryRepository;

    public CategoryUpdateService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category initCategory(CategoryId id, String name, String description, CategoryId parentId, CategoryStatus status) throws InvalidCategoryException{
        Category category = new Category(id, name, description, parentId, status);
        CategoryValidationNotificationHandler notificationHandler = new CategoryValidationNotificationHandler();
        category.validate(categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return category;
        } else {
            throw new InvalidCategoryException(String.format("Invalid category. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }
}
