package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Getter
public class Product implements AggregateRoot<Long> {
    private Long id;
    private Long categoryId;
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
    private long version;
    private ProductPriceInfo priceInfo;
    private List<TierVariation> tierVariations;

    Product(Long id,
            Long categoryId,
            String description,
            List<Image> images,
            String name,
            PreOrder preOrder,
            ProductDimension productDimension,
            int stockQuantity,
            Video video,
            ProductStatus status,
            long totalSold,
            int displayPriority,
            long version,
            ProductPriceInfo priceInfo,
            List<TierVariation> tierVariations) throws InvalidProductException {
        this.id = id;
        this.categoryId = categoryId;
        if (!isValidStringLength(description, 1000)) {
            throw new InvalidProductException("Category description must be non-null, trimmed, and up to 1000 characters");
        }
        if (CollectionUtils.isEmpty(images) || !isValidNumber(images.size(), 0, 9)) {
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
        this.status = status;
        this.totalSold = totalSold;
        this.displayPriority = displayPriority;
        this.version = version;
        this.video = video;
        this.priceInfo = priceInfo;
        this.tierVariations = tierVariations;
    }

    public void validate(ProductRepository productRepository,
                         CategoryRepository categoryRepository,
                         ValidationNotificationHandler validationNotificationHandler) {
        Validator productValidator = new ProductValidator(validationNotificationHandler, categoryRepository, productRepository, this);
        productValidator.validate();
    }

    public void updateProductInfo(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            Long categoryId,
            String description,
            List<Image> images,
            String name,
            PreOrder preOrder,
            ProductDimension productDimension,
            int stockQuantity,
            int displayPriority,
            Video video) throws InvalidProductException {
        ValidationNotificationHandlerImpl notificationHandler = new ValidationNotificationHandlerImpl();
        this.categoryId = categoryId;
        this.description = description;
        this.images = images;
        this.name = name;
        this.preOrder = preOrder;
        this.productDimension = productDimension;
        this.stockQuantity = stockQuantity;
        this.video = video;
        this.displayPriority = displayPriority;
        validate(productRepository, categoryRepository, notificationHandler);
        if (!notificationHandler.messages().isEmpty()) {
            throw new InvalidProductException(String.format("Invalid product. Reasons: %s", notificationHandler.concatenatedMessage()));
        }
    }

    public Product updateTierVariation(List<TierVariation> tierVariations) throws InvalidProductException {
        if (CollectionUtils.isEmpty(tierVariations)) {
            throw new InvalidProductException("Tier variations cannot be empty");
        }
        return new Product(this.id,
                this.categoryId,
                this.description,
                this.images,
                this.name,
                this.preOrder,
                this.productDimension,
                this.stockQuantity,
                this.video,
                this.status,
                this.totalSold,
                this.displayPriority,
                this.version,
                this.priceInfo,
                tierVariations);
    }

    private boolean isValidStringLength(String string, int length) {
        return !Objects.isNull(string) && !string.isBlank() && string.length() <= length;
    }

    private boolean isValidNumber(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public ProductMemento createSnapshot() {
        return new ProductMemento(this.id,
                this.categoryId,
                this.description,
                this.images,
                this.name,
                this.preOrder,
                this.productDimension,
                this.stockQuantity,
                this.video,
                this.status,
                this.totalSold,
                this.displayPriority,
                this.version,
                this.priceInfo,
                this.tierVariations);
    }

    @Getter
    @AllArgsConstructor
    public static class ProductMemento {
        private Long id;
        private Long categoryId;
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
        private long version;
        private ProductPriceInfo priceInfo;
        private List<TierVariation> tierVariations;

        public Product restore() throws InvalidProductVariantException {
            return new Product(this.id,
                    this.categoryId,
                    this.description,
                    this.images,
                    this.name,
                    this.preOrder,
                    this.productDimension,
                    this.stockQuantity,
                    this.video,
                    this.status,
                    this.totalSold,
                    this.displayPriority,
                    this.version,
                    this.priceInfo,
                    this.tierVariations);
        }
    }
}
