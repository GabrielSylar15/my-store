package com.vinhnt.api.core.application.port.inbound.inventory;

import java.util.List;

public class CategoryDetailResponseDTO {
    private Long id;
    private String name;
    private String description;
    List<CategoryDetailResponseDTO> children;
}
