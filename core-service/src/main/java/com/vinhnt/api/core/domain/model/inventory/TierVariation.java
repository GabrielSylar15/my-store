package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

import java.util.List;

public class TierVariation implements ValueObject {
    private final String name;
    private final List<String> options;
    private final List<Image> images;

    TierVariation(String name, List<String> options, List<Image> images) {
        this.name = name;
        this.options = options;
        this.images = images;
    }

    String getName() {
        return name;
    }

    List<String> getOptions() {
        return options;
    }

    List<Image> getImages() {
        return images;
    }
}
