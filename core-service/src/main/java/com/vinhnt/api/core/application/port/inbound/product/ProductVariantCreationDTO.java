package com.vinhnt.api.core.application.port.inbound.product;

import com.vinhnt.api.core.domain.model.inventory.ProductId;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;

import java.util.List;

public record ProductVariantCreationDTO(ProductId productId,
                                        List<TierVariation> tierVariation,
                                        List<ProductVariantDTO> variants) {
}
