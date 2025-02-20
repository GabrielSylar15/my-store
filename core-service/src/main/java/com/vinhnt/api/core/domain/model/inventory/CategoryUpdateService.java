package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryUpdateService {
    private final CategoryRepository categoryRepository;

    public CategoryUpdateService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category initCategory(Long id, String name, String description, Long parentId, CategoryStatus status) throws InvalidCategoryException{
        Category category = new Category(id, name, description, parentId, status);
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        category.validate(categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return category;
        } else {
            throw new InvalidCategoryException(String.format("Invalid category. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }
}
