package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class Image implements ValueObject {
    private final String url;
    private final String imageRation;

    Image(String url, String imageRation) {
        this.url = url;
        this.imageRation = imageRation;
    }

    String getUrl() {
        return url;
    }

    String getImageRation() {
        return imageRation;
    }
}
