package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetailResponseDTO {
    private List<TierVariation> tierVariations;
    private long id;
    private long categoryId;
    private String description;
    private List<ImageDTO> images;
    private String name;
    private PreOrderDTO preOrder;
    private ProductDimension productDimension;
    private int stockQuantity;
    private VideoDTO video;
    private ProductStatus status;
    private long totalSold;
    private int displayPriority;
    private ProductPriceInfoDTO priceInfo;
    private List<ProductVariantDTO> productVariants;
    private List<TierVariation> tierVariants;
}
