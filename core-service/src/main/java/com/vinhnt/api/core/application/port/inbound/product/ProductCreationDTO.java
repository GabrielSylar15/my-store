package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.*;

import java.util.List;

public record ProductCreationDTO(CategoryId categoryId,
                                 String description,
                                 List<Image> images,
                                 String name,
                                 PreOrder preOrder,
                                 ProductDimension productDimension,
                                 int stockQuantity,
                                 Video video,
                                 Wholesale wholesale) {
}
