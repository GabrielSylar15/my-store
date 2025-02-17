package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class PreOrder implements ValueObject {
    private final boolean isPreOrder;
    private final int daysToShip;

    public PreOrder(boolean isPreOrder, int daysToShip) {
        this.isPreOrder = isPreOrder;
        this.daysToShip = daysToShip;
    }

    boolean getPreOrder() {
        return isPreOrder;
    }

    int getDaysToShip() {
        return daysToShip;
    }
}
