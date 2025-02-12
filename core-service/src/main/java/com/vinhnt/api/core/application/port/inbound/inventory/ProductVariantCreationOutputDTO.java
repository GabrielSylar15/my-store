package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.ProductId;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;

import java.util.List;

public record ProductVariantCreationOutputDTO(ProductId productId, List<TierVariation> tierVariations,
                                              List<ProductVariant> variants) {
}
