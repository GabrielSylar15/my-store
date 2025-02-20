package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.Category;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryApplicationService {
    private final CategoryCreation categoryCreation;
    private final CategoryUpdate categoryUpdate;
    private final CategoryDetail categoryDetail;
    private final CategoryList categoryList;

    public CategoryDetailResponseDTO createCategory(CategoryCreationDTO categoryCreationDTO) {
        return categoryCreation.createCategory(categoryCreationDTO);
    }

    public Category updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        return categoryUpdate.updateCategory(categoryUpdateDTO);
    }

    public CategoryDetailResponseDTO getCategory(Long id) {
        return categoryDetail.getCategoryDetail(id);
    }

    public List<CategoryDetailResponseDTO> getCategoryList() {
        return categoryList.getAllCategoryParents();
    }

}
