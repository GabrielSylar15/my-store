package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.vinhnt.api.core.domain.model.inventory.ProductPriceInfo;
import com.vinhnt.common.util.JsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PriceInfoConverter implements AttributeConverter<ProductPriceInfo, String> {
    @Override
    public String convertToDatabaseColumn(ProductPriceInfo attribute) {
        return JsonUtil.stringify(attribute);
    }

    @Override
    public ProductPriceInfo convertToEntityAttribute(String dbData) {
        return JsonUtil.parse(dbData, ProductPriceInfo.class);
    }
}
