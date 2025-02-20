package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

import java.util.Objects;

public class CategoryValidator extends Validator {
    private final Category category;
    private final CategoryRepository categoryRepository;

    public CategoryValidator(ValidationNotificationHandler validationNotificationHandler, Category category, CategoryRepository categoryRepository) {
        super(validationNotificationHandler);
        this.category = category;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void validate() {
        if (Objects.nonNull(category.getId())) {
            Category existedCategory = categoryRepository.findById(category.getId());
            if (Objects.isNull(existedCategory)) {
                validationNotificationHandler.handleError("Category with id " + category.getId() + " does not exist");
            }
        }
        if (Objects.nonNull(category.getParentId())) {
            Category parentCategory = categoryRepository.findById(category.getParentId());
            if (Objects.isNull(parentCategory)) {
                validationNotificationHandler.handleError("Parent category not found");
            }
        }
    }
}
