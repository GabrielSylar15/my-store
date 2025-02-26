package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter;

import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ListIntegerConverter extends GenericListConverter<Integer> {
}
