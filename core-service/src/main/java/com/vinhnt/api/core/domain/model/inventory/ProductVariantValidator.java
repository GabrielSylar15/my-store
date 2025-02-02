package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

public class ProductVariantValidator extends Validator {
    private ProductVariant productVariant;
    private ProductRepository productRepository;
    public ProductVariantValidator(ValidationNotificationHandler validationNotificationHandler, ProductVariant productVariant, ProductRepository productRepository) {
        super(validationNotificationHandler);
        this.productVariant = productVariant;
        this.productRepository = productRepository;
    }

    @Override
    public void validate() {

    }
}
