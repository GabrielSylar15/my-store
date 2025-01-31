package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.Entity;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;

import java.util.Objects;

public class Category implements Entity<CategoryId> {
    private String name;
    private String description;
    private CategoryId parentId;
    private CategoryStatus status;
    private CategoryId id;

    Category(CategoryId id, String name, String description, CategoryId parentId, CategoryStatus status) throws InvalidCategoryException {
        this.id = id;
        if (isValidStringLength(name, 120)) {
            this.name = name;
        } else {
            throw new InvalidCategoryException("Category name must be non-null, trimmed, and up to 120 characters");
        }
        if (isValidStringLength(description, 1000)) {
            this.description = description;
        } else {
            throw new InvalidCategoryException("Category description must be non-null, trimmed, and up to 1000 characters");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    private boolean isValidStringLength(String string, int length) {
        return !Objects.isNull(string) && !string.isBlank() && string.length() <= length;
    }

}
