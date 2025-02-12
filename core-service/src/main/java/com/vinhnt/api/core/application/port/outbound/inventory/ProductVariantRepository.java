package com.vinhnt.api.core.application.port.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantId;

public interface ProductVariantRepository extends BaseRepository<ProductVariant, ProductVariantId> {
}
