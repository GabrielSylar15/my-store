package com.vinhnt.applicationservice.config;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryDetail;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryList;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdate;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.usecase.inventory.CategoryCreationImpl;
import com.vinhnt.api.core.application.usecase.inventory.CategoryDetailImpl;
import com.vinhnt.api.core.application.usecase.inventory.CategoryListImpl;
import com.vinhnt.api.core.application.usecase.inventory.CategoryUpdateImpl;
import com.vinhnt.api.core.domain.model.inventory.CategoryCreationService;
import com.vinhnt.api.core.domain.model.inventory.CategoryUpdateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfiguration {
    @Bean
    public CategoryCreationService categoryCreationService(CategoryRepository categoryRepository) {
        return new CategoryCreationService(categoryRepository);
    }

    @Bean
    public CategoryCreation categoryCreation(CategoryRepository categoryRepository, CategoryCreationService categoryCreationService) {
        return new CategoryCreationImpl(categoryCreationService, categoryRepository);
    }

    @Bean
    public CategoryUpdateService categoryUpdate(CategoryRepository categoryRepository) {
        return new CategoryUpdateService(categoryRepository);
    }

    @Bean
    public CategoryUpdate updateCategory(CategoryRepository categoryRepository, CategoryUpdateService categoryUpdateService) {
        return new CategoryUpdateImpl(categoryRepository, categoryUpdateService);
    }

    @Bean
    public CategoryDetail categoryDetail(CategoryRepository categoryRepository) {
        return new CategoryDetailImpl(categoryRepository);
    }

    @Bean
    public CategoryList categoryList(CategoryRepository categoryRepository) {
        return new CategoryListImpl(categoryRepository);
    }
}
