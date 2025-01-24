package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.Entity;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;

public class Category implements Entity<CategoryId> {
    private String name;
    private String description;
    private CategoryId parentId;
    private CategoryStatus status;
    private CategoryId id;

    Category(String name, String description, CategoryId parentId, CategoryStatus status) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
        this.status = status;
    }

    public void validate(CategoryRepository categoryRepository, ValidationNotificationHandler validationNotificationHandler) {
        CategoryValidator categoryValidator = new CategoryValidator(validationNotificationHandler, this, categoryRepository);
        categoryValidator.validate();
    }

    CategoryId getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }


    CategoryId getParentId() {
        return parentId;
    }

    CategoryStatus getStatus() {
        return status;
    }

}
