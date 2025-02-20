package com.vinhnt.api.core.application.port.inbound.inventory;

import java.util.List;

public interface CategoryList {
    List<CategoryDetailResponseDTO> getAllCategoryParents();
}
