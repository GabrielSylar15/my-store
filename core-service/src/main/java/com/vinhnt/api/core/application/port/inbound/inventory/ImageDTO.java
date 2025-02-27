package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.Image;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ImageDTO(String url, String imageRation) {
    public Image toImage(String url, String imageRation) {
        return new Image(url, imageRation);
    }
}
