package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Wholesale implements ValueObject {
    private final int minCount;
    private final int maxCount;
    private final long unitPrice;

    Wholesale(int minCount, int maxCount, long unitPrice) {
        if (minCount > maxCount) {
            throw new IllegalArgumentException("min value must be less than maxCount");
        }
        if (minCount < 0) {
            throw new IllegalArgumentException("min value must be greater than zero");
        }
        if (maxCount < Integer.MAX_VALUE) {
            throw new IllegalArgumentException("max value must be less than Integer.MAX_VALUE");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unit price must be greater than zero");
        }
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.unitPrice = unitPrice;
    }

    int getMinCount() {
        return minCount;
    }

    int getMaxCount() {
        return maxCount;
    }

    long getUnitPrice() {
        return unitPrice;
    }
}
