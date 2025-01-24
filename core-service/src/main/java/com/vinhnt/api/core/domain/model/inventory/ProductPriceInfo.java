package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class ProductPriceInfo implements ValueObject {
    private String currency;
    private Long currentPrice;
    private Long originalPrice;
    private Long wholesalePrice;
}
