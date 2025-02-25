package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.Image;
import com.vinhnt.api.core.domain.model.inventory.PreOrder;
import com.vinhnt.api.core.domain.model.inventory.ProductDimension;
import com.vinhnt.api.core.domain.model.inventory.Video;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductUpdateInfoDTO(Long productId,
                                   Long categoryId,
                                   String description,
                                   List<Image> images,
                                   String name,
                                   PreOrder preOrder,
                                   ProductDimension productDimension,
                                   int stockQuantity,
                                   int displayPriority,
                                   Video video) {
}
