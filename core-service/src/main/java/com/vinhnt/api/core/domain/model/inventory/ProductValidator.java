package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

import java.util.Objects;

public class ProductValidator extends Validator {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private Product product;

    public ProductValidator(ValidationNotificationHandler validationNotificationHandler, CategoryRepository categoryRepository, ProductRepository productRepository, Product product) {
        super(validationNotificationHandler);
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.product = product;
    }

    @Override
    public void validate() {
        Category category = categoryRepository.findById(product.getCategoryId());
        if (Objects.isNull(category)) {
            validationNotificationHandler.handleError("Category does not exist");
        }
        if (Objects.nonNull(product.getId())) {
            Product existedProduct = productRepository.findById(product.getId());
            if (Objects.isNull(existedProduct)) {
                validationNotificationHandler.handleError("Product with id " + product.getId() + " does not exist");
            }
        }

    }
}
