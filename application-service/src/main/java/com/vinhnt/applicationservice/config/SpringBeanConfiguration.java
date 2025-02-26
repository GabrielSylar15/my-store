package com.vinhnt.applicationservice.config;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.application.usecase.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.CategoryCreationService;
import com.vinhnt.api.core.domain.model.inventory.CategoryUpdateService;
import com.vinhnt.api.core.domain.model.inventory.ProductCreationService;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantCreationService;
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

    @Bean ProductDetail productDetail(ProductRepository productRepository, ProductVariantRepository productVariantRepository) {
        return new ProductDetailImpl(productRepository, productVariantRepository);
    }

    @Bean
    public ProductVariantCreationService productVariantCreationService(ProductVariantRepository productVariantRepository, ProductRepository productRepository) {
        return new ProductVariantCreationService(productVariantRepository, productRepository);
    }

    @Bean
    public ProductVariantCreation productVariantCreation(ProductVariantRepository productVariantRepository, ProductRepository productRepository, ProductVariantCreationService productVariantCreationService) {
        return new ProductVariantCreationImpl(productVariantRepository, productRepository, productVariantCreationService);
    }
}
