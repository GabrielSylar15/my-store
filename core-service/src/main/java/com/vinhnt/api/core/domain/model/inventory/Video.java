package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public record Video(String id, String thumbnailUrl, int duration) implements ValueObject {
    public Video {
        if (id.isBlank() || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Video id cannot be blank");
        }
    }
}
