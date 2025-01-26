package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.CategoryId;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

public record CategoryUpdateDTO(CategoryId id, String name, String description, CategoryId parentId,
                                CategoryStatus status) {
}
