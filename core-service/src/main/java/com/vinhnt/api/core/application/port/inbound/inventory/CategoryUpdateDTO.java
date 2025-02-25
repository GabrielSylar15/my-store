package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CategoryUpdateDTO(Long id, String name, String description, Long parentId,
                                CategoryStatus status) {
}
