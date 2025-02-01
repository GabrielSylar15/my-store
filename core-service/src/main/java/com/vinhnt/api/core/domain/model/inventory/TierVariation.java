package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

import java.util.List;

public class TierVariation implements ValueObject {
    private String name;
    private List<String> options;
    private List<Image> images;
}
