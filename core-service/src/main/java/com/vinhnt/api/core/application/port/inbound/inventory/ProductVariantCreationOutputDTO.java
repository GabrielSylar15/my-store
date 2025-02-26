package com.vinhnt.api.core.application.port.inbound.inventory;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductVariantCreationOutputDTO(Long productId,
                                              List<TierVariation> tierVariations,
                                              List<ProductVariant> variants) {
}
