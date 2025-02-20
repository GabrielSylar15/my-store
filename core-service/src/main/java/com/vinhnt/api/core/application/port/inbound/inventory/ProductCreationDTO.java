package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.Image;
import com.vinhnt.api.core.domain.model.inventory.PreOrder;
import com.vinhnt.api.core.domain.model.inventory.ProductDimension;
import com.vinhnt.api.core.domain.model.inventory.Video;

import java.util.List;

public record ProductCreationDTO(Long categoryId,
                                 String description,
                                 List<Image> images,
                                 String name,
                                 PreOrder preOrder,
                                 ProductDimension productDimension,
                                 int stockQuantity,
                                 Video video) {
}
