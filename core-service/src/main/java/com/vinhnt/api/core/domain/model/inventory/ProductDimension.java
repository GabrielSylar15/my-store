package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class ProductDimension implements ValueObject {
    private static final Long MAX_HEIGHT = 300L;
    private static final Long MIN_HEIGHT = 1L;
    private static final Long MAX_WIDTH = 300L;
    private static final Long MIN_WIDTH = 1L;
    private static final Long MAX_WEIGHT = 50000L;
    private static final Long MIN_WEIGHT = 1L;
    private final long weight;
    private final long height;
    private final long width;
    private final long length;

    ProductDimension(long weight, long height, long width, long length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    long getWeight() {
        return weight;
    }

    long getHeight() {
        return height;
    }

    long getWidth() {
        return width;
    }

    long getLength() {
        return length;
    }
}
