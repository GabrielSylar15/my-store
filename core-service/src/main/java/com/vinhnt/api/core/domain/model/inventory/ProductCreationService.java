package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.application.port.inbound.product.ProductCreationDTO;

import java.util.List;

public class ProductCreationService {
    public Product initProduct(CategoryId categoryId,
                               String description,
                               List<Image> images,
                               String name,
                               PreOrder preOrder,
                               ProductDimension productDimension,
                               int stockQuantity,
                               Video video,
                               Wholesale wholesale) {

    }
}
