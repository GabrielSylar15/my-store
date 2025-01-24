package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

import java.util.List;

public class ProductAttribute implements ValueObject {
    private String name;
    private List<ProductOption> optionList;
}
