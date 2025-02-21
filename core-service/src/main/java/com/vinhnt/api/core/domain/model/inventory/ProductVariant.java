package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.AggregateRoot;
import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class ProductVariant implements AggregateRoot<ProductVariantId> {
    private ProductVariantId id;
    private Long productId;
    private ProductPriceInfo priceInfo;
    private ProductVariantStatus status;
    private int stockQuantity;
    private String sku;
    private long sold;
    private int[] tierIndex;

    ProductVariant(ProductVariantId id,
                   Long productId,
                   ProductPriceInfo priceInfo,
                   ProductVariantStatus status,
                   int stockQuantity,
                   String sku,
                   long sold,
                   int[] tierIndex) throws InvalidProductVariantException {
        this.id = id;
        if (sold < 0) {
            throw new InvalidProductVariantException("Sold amount cannot be negative");
        }
        if (stockQuantity < 0) {
            throw new InvalidProductVariantException("Stock quantity cannot be negative");
        }
        if (tierIndex == null || tierIndex.length == 0) {
            throw new InvalidProductVariantException("Tier index cannot be null or empty");
        }
        if (sku == null || sku.isEmpty() || sku.length() > 24) {
            throw new InvalidProductVariantException("Sku cannot be null or empty");
        }
        this.priceInfo = priceInfo;
        this.productId = productId;
        this.sku = sku;
        this.sold = sold;
        this.status = status;
        this.stockQuantity = stockQuantity;
        this.tierIndex = tierIndex;
    }

    public void validate(ProductRepository productRepository,
                         ValidationNotificationHandler validationNotificationHandler,
                         List<TierVariation> tierVariations) {
        Validator productVariantValidator = new ProductVariantValidator(validationNotificationHandler, this, productRepository, tierVariations);
        productVariantValidator.validate();
    }

    ProductVariantId getId() {
        return id;
    }

    ProductPriceInfo getPriceInfo() {
        return priceInfo;
    }

    Long getProductId() {
        return productId;
    }

    String getSku() {
        return sku;
    }

    long getSold() {
        return sold;
    }

    ProductVariantStatus getStatus() {
        return status;
    }

    int getStockQuantity() {
        return stockQuantity;
    }

    int[] getTierIndex() {
        return tierIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariant that = (ProductVariant) o;
        return Objects.equals(id, that.id) || (Objects.equals(productId, that.productId) && Objects.equals(priceInfo, that.priceInfo) && status == that.status && Objects.equals(sku, that.sku) && Objects.deepEquals(tierIndex, that.tierIndex));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, Arrays.hashCode(tierIndex));
    }
}
