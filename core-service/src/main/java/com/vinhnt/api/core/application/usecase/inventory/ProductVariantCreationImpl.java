package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantCreationService;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductVariantCreationImpl implements ProductVariantCreation {
    private final ProductVariantRepository productVariantRepository;
    private final ProductRepository productRepository;
    private final ProductVariantCreationService productVariantCreationService;
    public ProductVariantCreationImpl(ProductVariantRepository productVariantRepository,
                                      ProductRepository productRepository,
                                      ProductVariantCreationService productVariantCreationService) {
        this.productVariantRepository = productVariantRepository;
        this.productRepository = productRepository;
        this.productVariantCreationService = productVariantCreationService;
    }

    @Override
    public ProductVariantCreationDTO addProductVariant(ProductVariantAddItemDTO addProductVariantDTO) {
        return null;
    }

    @Override
    public ProductVariantCreationOutputDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) throws InvalidProductVariantException, InvalidProductException {
        List<ProductVariant> productVariants = productVariantRepository.findByProductIdAndStatus(productVariantCreationDTO.productId(), ProductVariantStatus.AVAILABLE);
        if (!productVariants.isEmpty()) {
            productVariantRepository.deleteAll(productVariants);
        } else {
            productVariants = new ArrayList<>();
        }
        for (ProductVariantDTO variant : productVariantCreationDTO.variants()) {
            productVariants.add(productVariantCreationService.initProductVariant(productVariantCreationDTO.tierVariation(),
                    productVariantCreationDTO.productId(),
                    variant.priceInfo().toProductPriceInfo(),
                    variant.status(),
                    variant.stockQuantity(),
                    variant.sku(),
                    variant.sold(),
                    variant.tierIndex()));
        }
        productVariantRepository.saveAll(productVariants);
        Product product = productRepository.findById(productVariantCreationDTO.productId());
        if (Objects.isNull(product)) {
            throw new InvalidProductVariantException("Product not found");
        }
        product = product.updateTierVariation(productVariantCreationDTO.tierVariation());
        productRepository.save(product);
        return new ProductVariantCreationOutputDTO(productVariantCreationDTO.productId(), productVariantCreationDTO.tierVariation(), productVariants);
    }
}
