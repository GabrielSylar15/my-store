package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

public class CategoryCreationService {
    private final CategoryRepository categoryRepository;

    public CategoryCreationService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category initCategory(String name, String description, CategoryId parentId) throws InvalidCategoryException {
        Category category = new Category(null, name, description, parentId, CategoryStatus.ACTIVE);
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        category.validate(categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return category;
        } else {
            throw new InvalidCategoryException(String.format("Invalid category. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }
}
