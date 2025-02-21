package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.TierVariation;

import java.util.List;
import java.util.Set;

public record ProductVariantCreationDTO(Long productId,
                                        List<TierVariation> tierVariation,
                                        Set<ProductVariantDTO> variants) {
}
