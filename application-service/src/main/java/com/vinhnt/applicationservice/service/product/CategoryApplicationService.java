package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreationDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdate;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdateDTO;
import com.vinhnt.api.core.domain.model.inventory.Category;
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

    @SneakyThrows
    public Category updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        return categoryUpdate.updateCategory(categoryUpdateDTO);
    }

    public Category getCategory(Long id) {
        return null;
    }

}
