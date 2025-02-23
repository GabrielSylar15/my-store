package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.Entity;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Category implements Entity<Long> {
    private String name;
    private String description;
    private Long parentId;
    private CategoryStatus status;
    private Long id;

    Category(Long id, String name, String description, Long parentId, CategoryStatus status) throws InvalidCategoryException {
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

    public CategoryMemento createSnapshot() {
        return new CategoryMemento(this.name, this.description, this.parentId, this.status, this.id);
    }

    @Getter
    @AllArgsConstructor
    public static class CategoryMemento {
        private String name;
        private String description;
        private Long parentId;
        private CategoryStatus status;
        private Long id;

        public Category restore() throws InvalidCategoryException {
            return new Category(this.id, this.name, this.description, this.parentId, this.status);
        }
    }

}
