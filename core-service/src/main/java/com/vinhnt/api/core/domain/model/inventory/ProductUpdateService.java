package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ProductUpdateService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductUpdateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product initProduct(ProductId productId,
                               Long categoryId,
                               String description,
                               List<Image> images,
                               String name,
                               PreOrder preOrder,
                               ProductDimension productDimension,
                               int stockQuantity,
                               Video video) throws InvalidProductException {
        Product product = new Product(productId, categoryId, description, images, name, preOrder, productDimension, stockQuantity, video, null);
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        product.validate(productRepository, categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return product;
        } else {
            throw new InvalidProductException(String.format("Invalid product. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }

    public Product initProductUpdateTierVariation(Product product, List<TierVariation> tierVariations) throws InvalidProductException {
        product = new Product(product.getId(),
                product.getCategoryId(),
                product.getDescription(),
                product.getImages(),
                product.getName(),
                product.getPreOrder(),
                product.getProductDimension(),
                product.getStockQuantity(),
                product.getVideo(),
                product.getTierVariations());
        if (CollectionUtils.isEmpty(tierVariations)) {
            throw new InvalidProductException("Tier variations cannot be empty");
        }
        return product;
    }
}
