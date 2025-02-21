package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.vinhnt.api.core.domain.model.inventory.Video;
import com.vinhnt.common.util.JsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class VideoConverter implements AttributeConverter<Video, String> {
    @Override
    public String convertToDatabaseColumn(Video attribute) {
        return JsonUtil.stringify(attribute);
    }

    @Override
    public Video convertToEntityAttribute(String dbData) {
        return JsonUtil.parse(dbData, Video.class);
    }
}
