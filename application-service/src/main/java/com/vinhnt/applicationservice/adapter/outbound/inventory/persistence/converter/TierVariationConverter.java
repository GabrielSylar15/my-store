package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;
import com.vinhnt.common.util.JsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter(autoApply = true)
public class TierVariationConverter implements AttributeConverter<List<TierVariation>, String> {
    @Override
    public String convertToDatabaseColumn(List<TierVariation> attribute) {
        return JsonUtil.stringify(attribute);
    }

    @Override
    public List<TierVariation> convertToEntityAttribute(String dbData) {
        return JsonUtil.parse(dbData, new TypeReference<>() {
        });
    }
}
