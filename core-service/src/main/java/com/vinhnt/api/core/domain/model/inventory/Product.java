package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.oubound.product.CategoryRepository;
import com.vinhnt.api.core.application.port.oubound.product.ProductRepository;
import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

import java.util.List;

public class Product implements AggregateRoot<ProductId> {
    private ProductId id;
    private String name;
    private String description;
    private CategoryId categoryId;
    private PreOrder preOrder;
    private List<Image> images;
    private Video video;
    private ProductDimension productDimension;
    private int stockQuantity;
    private Wholesale wholesale;

    public void validate(ProductRepository productRepository,
                         CategoryRepository CategoryRepository,
                         ValidationNotificationHandler validationNotificationHandler) {
        Validator productValidator = new ProductValidator(validationNotificationHandler, this, categoryRepository);
        productValidator.validate();
    }

    Product(CategoryId categoryId,
            String description,
            ProductId id,
            List<Image> images,
            String name,
            PreOrder preOrder,
            ProductDimension productDimension,
            int stockQuantity,
            Video video,
            Wholesale wholesale) {
        this.categoryId = categoryId;
        this.description = description;
        this.id = id;
        this.images = images;
        this.name = name;
        this.preOrder = preOrder;
        this.productDimension = productDimension;
        this.stockQuantity = stockQuantity;
        this.video = video;
        this.wholesale = wholesale;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public ProductId getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public PreOrder getPreOrder() {
        return preOrder;
    }

    public ProductDimension getProductDimension() {
        return productDimension;
    }

    public List<ProductVariant> getProductVariants() {
        return productVariants;
    }

    public Video getVideo() {
        return video;
    }
}
