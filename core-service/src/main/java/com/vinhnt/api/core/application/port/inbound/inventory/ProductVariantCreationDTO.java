package com.vinhnt.api.core.application.port.inbound.inventory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;

import java.util.List;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductVariantCreationDTO(Long productId,
                                        List<TierVariation> tierVariation,
                                        Set<ProductVariantDTO> variants) {
}
