package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

import java.util.Objects;

public class CategoryValidator extends Validator {
    private Category category;
    private CategoryRepository categoryRepository;

    public CategoryValidator(ValidationNotificationHandler validationNotificationHandler, Category category, CategoryRepository categoryRepository) {
        super(validationNotificationHandler);
        this.category = category;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void validate() {
        Category parentCategory = categoryRepository.findById(category.getParentId());
        if (Objects.isNull(parentCategory)) {
            validationNotificationHandler.handleError("Parent category not found");
        }
    }
}
