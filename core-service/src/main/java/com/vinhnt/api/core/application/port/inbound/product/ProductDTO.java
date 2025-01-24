package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.*;

import java.util.List;

public record ProductDTO(String name,
                         String description,
                         CategoryId categoryId,
                         ProductAttribute attribute,
                         PreOrder preOrder,
                         List<Image> images,
                         Video video,
                         ProductDimension dimension) {
}
