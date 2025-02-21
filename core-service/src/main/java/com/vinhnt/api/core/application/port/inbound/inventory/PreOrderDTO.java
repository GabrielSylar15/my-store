package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.PreOrder;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PreOrderDTO(boolean isPreOrder, int daysToShip) {
    public PreOrder toPreOrder() {
        return new PreOrder(isPreOrder, daysToShip);
    }
}
