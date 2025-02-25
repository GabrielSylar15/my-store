package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;
import lombok.Getter;

import java.util.List;

@Getter
public class TierVariation implements ValueObject {
    private final String name;
    private final List<String> options;
    private final List<Image> images;

    public TierVariation(String name, List<String> options, List<Image> images) {
        this.name = name;
        this.options = options;
        this.images = images;
    }
}
