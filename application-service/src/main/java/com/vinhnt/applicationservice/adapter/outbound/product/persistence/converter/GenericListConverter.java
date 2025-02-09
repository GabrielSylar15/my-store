package com.vinhnt.applicationservice.adapter.outbound.product.persistence.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vinhnt.common.util.JsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter(autoApply = true)
public class GenericListConverter<T> implements AttributeConverter<List<T>, String> {
    @Override
    public String convertToDatabaseColumn(List<T> attribute) {
        return JsonUtil.stringify(attribute);
    }

    @Override
    public List<T> convertToEntityAttribute(String dbData) {
        return JsonUtil.parse(dbData, new TypeReference<>() {
        });
    }
}
