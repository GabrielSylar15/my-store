package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.CategoryRepository;
import com.vinhnt.api.core.domain.model.inventory.Category;
import com.vinhnt.api.core.domain.model.inventory.CategoryStatus;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidCategoryException;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPACategory;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPACategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final JPACategoryRepository jpaCategoryRepository;

    public CategoryRepositoryImpl(JPACategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public List<Category> findByParentIdAndStatus(Long parentId, CategoryStatus status) {
        List<JPACategory> jpaCategories = jpaCategoryRepository.findByParentIdAndStatus(parentId, status);
        if (jpaCategories.isEmpty()) {
            return new ArrayList<>();
        }
        return jpaCategories.stream().map(this::convertToDomainModel).toList();
    }

    @Override
    public Category findFirstByIdAndStatus(Long id, CategoryStatus status) {
        JPACategory jpaCategory = jpaCategoryRepository.findFirstByIdAndStatus(id, status);
        if (Objects.isNull(jpaCategory)) {
            return null;
        }
        return convertToDomainModel(jpaCategory);
    }

    @Override
    public void delete(Category data) {

    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category save(Category category) {
        JPACategory jpaCategory = convertToJPAModel(category);
        jpaCategory = jpaCategoryRepository.save(jpaCategory);
        return convertToDomainModel(jpaCategory);
    }

    @Override
    public Category findById(Long id) {
        return jpaCategoryRepository.findById(id)
                .map(this::convertToDomainModel)
                .orElse(null);
    }

    @Override
    public List<Category> saveAll(Iterable<Category> data) {
        return List.of();
    }


    private JPACategory convertToJPAModel(Category category) {
        JPACategory jpaCategory = new JPACategory();
        Category.CategoryMemento categoryMemento = category.createSnapshot();
        jpaCategory.setId(categoryMemento.getId());
        jpaCategory.setDescription(categoryMemento.getDescription());
        jpaCategory.setName(categoryMemento.getName());
        jpaCategory.setStatus(categoryMemento.getStatus());
        jpaCategory.setParentId(categoryMemento.getParentId());
        return jpaCategory;
    }

    private Category convertToDomainModel(JPACategory jpaCategory) throws InvalidCategoryException {
        Category.CategoryMemento categoryMemento = new Category.CategoryMemento(jpaCategory.getDescription(), jpaCategory.getId(), jpaCategory.getName(), jpaCategory.getParentId(), jpaCategory.getStatus());
        return categoryMemento.restore();
    }
}
