package com.vinhnt.applicationservice.adapter.outbound.inventory;

import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.domain.model.inventory.PreOrder;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductDimension;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductException;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProduct;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JPAProductRepository jpaProductRepository;

    @Override
    public Product findAvailableProductById(Long productId) {
        return convertToDomainModel(jpaProductRepository.findAvailableProductById(productId));
    }

    @Override
    public void delete(Product data) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product data) {
        JPAProduct jpaProduct = convertToJPAProduct(data);
        return convertToDomainModel(jpaProductRepository.save(jpaProduct));
    }

    @Override
    public Product findById(Long productId) {
        return jpaProductRepository.findById(productId)
                .map(this::convertToDomainModel)
                .orElse(null);
    }

    @Override
    public List<Product> saveAll(Iterable<Product> data) {
        return List.of();
    }

    public JPAProduct convertToJPAProduct(Product product) {
        JPAProduct productEntity = new JPAProduct();
        Product.ProductMemento productMemento = product.createSnapshot();
        productEntity.setId(productMemento.getId());
        productEntity.setHeight(productMemento.getProductDimension().getHeight());
        productEntity.setWeight(productMemento.getProductDimension().getWeight());
        productEntity.setWidth(productMemento.getProductDimension().getWidth());
        productEntity.setLength(productMemento.getProductDimension().getLength());
        productEntity.setStockQuantity(productMemento.getStockQuantity());
        productEntity.setDescription(productMemento.getDescription());
        productEntity.setName(productMemento.getName());
        productEntity.setImages(productMemento.getImages());
        productEntity.setDisplayPriority(productMemento.getDisplayPriority());
        productEntity.setDaysToShip(productMemento.getPreOrder().daysToShip());
        productEntity.setIsPreOrder(productMemento.getPreOrder().isPreOrder());
        productEntity.setStatus(productMemento.getStatus());
        productEntity.setCategoryId(productMemento.getCategoryId());
        productEntity.setTotalSold(productMemento.getTotalSold());
        productEntity.setTierVariations(productMemento.getTierVariations());
        productEntity.setVideo(productMemento.getVideo());
        productEntity.setVersion(product.getVersion());
        productEntity.setPriceInfo(product.getPriceInfo());
        return productEntity;
    }

    public Product convertToDomainModel(JPAProduct jpaProduct) throws InvalidProductException {
        PreOrder preOrder = new PreOrder(jpaProduct.getIsPreOrder(), jpaProduct.getDaysToShip());
        ProductDimension productDimension = new ProductDimension(jpaProduct.getWeight(), jpaProduct.getHeight(), jpaProduct.getWidth(), jpaProduct.getLength());
        return new Product.ProductMemento(jpaProduct.getId(),
                jpaProduct.getCategoryId(),
                jpaProduct.getDescription(),
                jpaProduct.getImages(),
                jpaProduct.getName(),
                preOrder,
                productDimension,
                jpaProduct.getStockQuantity(),
                jpaProduct.getVideo(),
                jpaProduct.getStatus(),
                jpaProduct.getTotalSold(),
                jpaProduct.getDisplayPriority(),
                jpaProduct.getVersion(),
                jpaProduct.getPriceInfo(),
                jpaProduct.getTierVariations())
                .restore();
    }
}
