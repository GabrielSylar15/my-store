package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.Video;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record VideoDTO(String id, String thumbnailUrl, int duration) {
    public Video toVideo() {
        return new Video(id, thumbnailUrl, duration);
    }

    public static VideoDTO fromVideo(Video video) {
        return new VideoDTO(video.id(), video.thumbnailUrl(), video.duration());
    }
}
