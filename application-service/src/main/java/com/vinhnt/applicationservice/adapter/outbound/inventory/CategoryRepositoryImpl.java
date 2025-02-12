package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public void delete(Category data) {

    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category save(Category data) {
        return null;
    }

    @Override
    public Category findById(CategoryId categoryId) {
        return null;
    }

    @Override
    public List<Category> saveAll(Iterable<Category> data) {
        return List.of();
    }
}
