package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class Wholesale implements ValueObject {
    private int minCount;
    private int maxCount;
    private Long unitPrice;
}
