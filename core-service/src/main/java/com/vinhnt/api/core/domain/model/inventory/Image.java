package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

public record Image(String url, String imageRation) implements ValueObject {
}
