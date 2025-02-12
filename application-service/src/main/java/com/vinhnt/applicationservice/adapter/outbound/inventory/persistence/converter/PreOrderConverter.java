package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.vinhnt.api.core.domain.model.inventory.PreOrder;
import com.vinhnt.common.util.JsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PreOrderConverter implements AttributeConverter<PreOrder, String> {
    @Override
    public String convertToDatabaseColumn(PreOrder attribute) {
        return JsonUtil.stringify(attribute);
    }

    @Override
    public PreOrder convertToEntityAttribute(String dbData) {
        return JsonUtil.parse(dbData, PreOrder.class);
    }
}
