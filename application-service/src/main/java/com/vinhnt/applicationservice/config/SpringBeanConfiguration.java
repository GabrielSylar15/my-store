package com.vinhnt.applicationservice.config;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.application.usecase.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.CategoryCreationService;
import com.vinhnt.api.core.domain.model.inventory.CategoryUpdateService;
import com.vinhnt.api.core.domain.model.inventory.ProductCreationService;
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

    @Bean
    public ProductCreationService productCreationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return new ProductCreationService(productRepository, categoryRepository);
    }

    @Bean
    public ProductCreation productCreation(ProductRepository productRepository, ProductCreationService productCreationService) {
        return new ProductCreationImpl(productRepository, productCreationService);
    }

    @Bean
    public ProductUpdate productUpdate(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return new ProductUpdateImpl(productRepository, categoryRepository);
    }
}
