package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductUpdate;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductUpdateInfoDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductStatus;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;

import java.util.Objects;

public class ProductUpdateImpl implements ProductUpdate {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductUpdateImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product updateProductInfo(ProductUpdateInfoDTO productUpdateInfoDTO) {
        Product product = productRepository.findAvailableProductById(productUpdateInfoDTO.productId());
        if (Objects.isNull(product)) {
            throw new InvalidProductException("Product is not valid");
        }
        product.updateProductInfo(productRepository, categoryRepository,
                productUpdateInfoDTO.categoryId(),
                productUpdateInfoDTO.description(),
                productUpdateInfoDTO.images(),
                productUpdateInfoDTO.name(),
                productUpdateInfoDTO.preOrder(),
                productUpdateInfoDTO.productDimension(),
                productUpdateInfoDTO.stockQuantity(),
                productUpdateInfoDTO.displayPriority(),
                productUpdateInfoDTO.video());
        return productRepository.save(product);
    }

    @Override
    public Product updateStockQuantity(Product product, int quantity) {
        return null;
    }

    @Override
    public Product updateProductStatus(Product product, ProductStatus status) {
        return null;
    }
}
