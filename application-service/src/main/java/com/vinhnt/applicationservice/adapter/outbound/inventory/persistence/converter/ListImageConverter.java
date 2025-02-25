package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import com.vinhnt.api.core.domain.model.inventory.Image;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ListImageConverter extends GenericListConverter<Image> {
}
