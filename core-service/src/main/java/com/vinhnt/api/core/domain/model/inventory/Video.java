package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public class Video implements ValueObject {
    private final String id;
    private final String thumbnailUrl;
    private final int duration;

    public Video(String id, String thumbnailUrl, int duration) {
        if (id.isBlank() || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Video id cannot be blank");
        }
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.duration = duration;
    }

    String getId() {
        return id;
    }
}
