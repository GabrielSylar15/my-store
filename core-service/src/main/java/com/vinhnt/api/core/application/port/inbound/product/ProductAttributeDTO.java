package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.ProductOption;

import java.util.List;

public record ProductAttributeDTO(String name, List<ProductOption> options) {
}
