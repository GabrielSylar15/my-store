package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public record PreOrder(boolean isPreOrder, int daysToShip) implements ValueObject {

}
