package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class Video implements ValueObject {
    private final String id;

    public Video(String id) {
        if (id.isBlank() || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Video id cannot be blank");
        }
        this.id = id;
    }

    String getId() {
        return id;
    }
}
