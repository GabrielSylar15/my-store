package com.vinhnt.api.core.application.usecase.product;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductCreationDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductCreationService;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;

public class ProductCreationImpl implements ProductCreation {
    private final ProductRepository productRepository;
    private final ProductCreationService productCreationService;

    public ProductCreationImpl(ProductRepository productRepository, ProductCreationService productCreationService) {
        this.productRepository = productRepository;
        this.productCreationService = productCreationService;
    }

    @Override
    public Product createProduct(ProductCreationDTO productCreationDTO) throws InvalidProductException {
        Product product = productCreationService.initProduct(productCreationDTO.categoryId(),
                productCreationDTO.description(),
                productCreationDTO.images(),
                productCreationDTO.name(),
                productCreationDTO.preOrder(),
                productCreationDTO.productDimension(),
                productCreationDTO.stockQuantity(),
                productCreationDTO.video());
        return productRepository.save(product);
    }
}
