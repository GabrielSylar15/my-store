package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDimension implements ValueObject {
    private static final Long MAX_HEIGHT = 300L;
    private static final Long MIN_HEIGHT = 1L;
    private static final Long MAX_WIDTH = 300L;
    private static final Long MIN_WIDTH = 1L;
    private static final Long MAX_WEIGHT = 50000L;
    private static final Long MIN_WEIGHT = 1L;
    private final float weight;
    private final float height;
    private final float width;
    private final float length;
}
