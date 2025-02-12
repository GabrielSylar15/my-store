package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class ProductVariantValidator extends Validator {
    private ProductVariant productVariant;
    private ProductRepository productRepository;
    private List<TierVariation> tierVariations;
    public ProductVariantValidator(ValidationNotificationHandler validationNotificationHandler,
                                   ProductVariant productVariant,
                                   ProductRepository productRepository,
                                   List<TierVariation> tierVariations) {
        super(validationNotificationHandler);
        this.productVariant = productVariant;
        this.productRepository = productRepository;
        this.tierVariations = tierVariations;
    }

    @Override
    public void validate() {
        Product product = productRepository.findById(productVariant.getProductId());
        if (Objects.isNull(product)) {
            validationNotificationHandler.handleError("Product not found");
        }
        if (CollectionUtils.isEmpty(tierVariations)) {
            validationNotificationHandler.handleError("Tier variation is invalid");
        }
        if (productVariant.getTierIndex().length != tierVariations.size()) {
            validationNotificationHandler.handleError("Tier index do not match");
        }
        for (int i = 0; i < productVariant.getTierIndex().length; i++) {
            TierVariation tierVariation = tierVariations.get(i);
            if (productVariant.getTierIndex()[i] > tierVariation.getOptions().size() || productVariant.getTierIndex()[i] < 0) {
                validationNotificationHandler.handleError("Tier index is invalid");
            }
        }
    }
}
