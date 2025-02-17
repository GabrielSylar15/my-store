package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.Id;

import java.util.Objects;

public class CategoryId implements Id {
    private final Long id;

    public CategoryId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
