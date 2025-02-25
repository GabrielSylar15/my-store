package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.vinhnt.api.core.domain.model.inventory.TierVariation;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TierVariationConverter extends GenericListConverter<TierVariation> {
}
