package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValueObject;

import java.util.List;

public record TierVariation(String name, List<String> options, List<Image> images) implements ValueObject {
}
