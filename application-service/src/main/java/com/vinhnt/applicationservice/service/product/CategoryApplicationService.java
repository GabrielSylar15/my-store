package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.product.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.product.CategoryCreationDTO;
import com.vinhnt.api.core.application.port.inbound.product.CategoryUpdate;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryApplicationService {
    private final CategoryCreation categoryCreation;
    private final CategoryUpdate categoryUpdate;

    @SneakyThrows
    public Category createCategory(CategoryCreationDTO categoryCreationDTO) {
        return categoryCreation.createCategory(categoryCreationDTO);
    }
}
