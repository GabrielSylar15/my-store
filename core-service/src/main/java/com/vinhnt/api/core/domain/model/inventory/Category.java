package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.Entity;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

public class Category implements Entity<CategoryId> {
    private final String name;
    private final String description;
    private final CategoryId parentId;
    private final CategoryStatus status;
    private final CategoryId id;

    Category(CategoryId id, String name, String description, CategoryId parentId, CategoryStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentId = parentId;
        this.status = status;
    }

    public void validate(CategoryRepository categoryRepository, ValidationNotificationHandler validationNotificationHandler) {
        Validator categoryValidator = new CategoryValidator(validationNotificationHandler, this, categoryRepository);
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
