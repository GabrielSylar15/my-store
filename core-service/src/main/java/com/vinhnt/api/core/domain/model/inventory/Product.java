package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class Product implements AggregateRoot<ProductId> {
    private ProductId id;
    private CategoryId categoryId;
    private String description;
    private List<Image> images;
    private String name;
    private PreOrder preOrder;
    private ProductDimension productDimension;
    private int stockQuantity;
    private Video video;
    private ProductStatus status;
    private long totalSold;
    private int displayPriority;
    private List<TierVariation> tierVariations;

    public void validate(ProductRepository productRepository,
                         CategoryRepository categoryRepository,
                         ValidationNotificationHandler validationNotificationHandler) {
        Validator productValidator = new ProductValidator(validationNotificationHandler, categoryRepository, productRepository, this);
        productValidator.validate();
    }

    Product(ProductId id,
            CategoryId categoryId,
            String description,
            List<Image> images,
            String name,
            PreOrder preOrder,
            ProductDimension productDimension,
            int stockQuantity,
            Video video,
            List<TierVariation> tierVariations) throws InvalidProductException {
        this.id = id;
        this.categoryId = categoryId;
        if (!isValidStringLength(description, 1000)) {
            throw new InvalidProductException("Category description must be non-null, trimmed, and up to 1000 characters");
        }
        if (CollectionUtils.isEmpty(images) || isValidNumber(images.size(), 0, 9)) {
            throw new InvalidProductException("Product images must contain at most 9 images");
        }
        if (!isValidStringLength(name, 120)) {
            throw new InvalidProductException("Product name must contain at most 120 characters");
        }
        if (!isValidNumber(stockQuantity, 0, Integer.MAX_VALUE)) {
            throw new InvalidProductException("Product stock quantity is invalid");
        }
        this.description = description;
        this.images = images;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.preOrder = preOrder;
        this.productDimension = productDimension;
        this.video = video;
        this.tierVariations = tierVariations;
    }

    CategoryId getCategoryId() {
        return categoryId;
    }

    String getDescription() {
        return description;
    }

    ProductId getId() {
        return id;
    }

    List<Image> getImages() {
        return images;
    }

    String getName() {
        return name;
    }

    PreOrder getPreOrder() {
        return preOrder;
    }

    ProductDimension getProductDimension() {
        return productDimension;
    }

    Video getVideo() {
        return video;
    }

    int getStockQuantity() {
        return stockQuantity;
    }

    long getTotalSold() {
        return totalSold;
    }

    List<TierVariation> getTierVariations() {
        return tierVariations;
    }

    private boolean isValidStringLength(String string, int length) {
        return !Objects.isNull(string) && !string.isBlank() && string.length() <= length;
    }

    private boolean isValidNumber(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
