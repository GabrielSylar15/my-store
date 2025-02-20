package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

public record CategoryUpdateDTO(Long id, String name, String description, Long parentId,
                                CategoryStatus status) {
}
