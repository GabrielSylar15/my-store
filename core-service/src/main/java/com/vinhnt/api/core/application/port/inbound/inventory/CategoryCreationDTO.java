package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.CategoryId;

public record CategoryCreationDTO(String name, String description, CategoryId parentId) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public CategoryId parentId() {
        return parentId;
    }
}
