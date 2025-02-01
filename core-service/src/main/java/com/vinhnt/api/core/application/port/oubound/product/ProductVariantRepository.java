package com.vinhnt.api.core.application.port.oubound.product;

import com.vinhnt.api.core.application.port.oubound.BaseRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantId;

public interface ProductVariantRepository extends BaseRepository<ProductVariant, ProductVariantId> {
}
