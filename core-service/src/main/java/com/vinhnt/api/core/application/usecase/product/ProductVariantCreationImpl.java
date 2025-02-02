package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.product.ProductVariantCreation;
import com.vinhnt.api.core.application.port.inbound.product.ProductVariantCreationDTO;
import com.vinhnt.api.core.application.port.inbound.product.ProductVariantCreationOutputDTO;
import com.vinhnt.api.core.application.port.inbound.product.ProductVariantDTO;
import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.application.port.oubound.product.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductUpdateService;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantCreationService;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductVariantCreationImpl implements ProductVariantCreation {
    private final ProductVariantRepository productVariantRepository;
    private final ProductRepository productRepository;
    private final ProductUpdateService productUpdateService;
    private final ProductVariantCreationService productVariantCreationService;

    public ProductVariantCreationImpl(ProductVariantRepository productVariantRepository, ProductRepository productRepository, ProductUpdateService productUpdateService, ProductVariantCreationService productVariantCreationService) {
        this.productVariantRepository = productVariantRepository;
        this.productRepository = productRepository;
        this.productUpdateService = productUpdateService;
        this.productVariantCreationService = productVariantCreationService;
    }

    @Override
    public ProductVariantCreationOutputDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) throws InvalidProductVariantException {
        Product product = productRepository.findById(productVariantCreationDTO.productId());
        if (Objects.isNull(product)) {
            throw new InvalidProductVariantException("Product not found");
        }
        product = productUpdateService.initProduct();
        productRepository.save(product);
        List<ProductVariant> productVariants = new ArrayList<>();
        for (ProductVariantDTO variant : productVariantCreationDTO.variants()) {
            productVariants.add(productVariantCreationService.initProductVariant(productVariantCreationDTO.productId(), variant.));

        } productVariantRepository.saveAll(productVariants);
        return new ProductVariantCreationOutputDTO(productVariantCreationDTO.productId(), productVariantCreationDTO.tierVariation(), productVariants);
    }
}
