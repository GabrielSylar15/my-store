package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;

import java.util.List;

public class ProductCreationService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductCreationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product initProduct(Long categoryId,
                               String description,
                               List<Image> images,
                               String name,
                               PreOrder preOrder,
                               ProductDimension productDimension,
                               int stockQuantity,
                               Video video) throws InvalidProductException {
        Product product = new Product(null, categoryId, description, images, name, preOrder, productDimension, stockQuantity, video, null);
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        product.validate(productRepository, categoryRepository, notificationHandler);
        if (notificationHandler.messages().isEmpty()) {
            return product;
        } else {
            throw new InvalidProductException(String.format("Invalid product. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }
}
