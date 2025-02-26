package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductDetail;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductDetailResponseDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ProductDetailImpl implements ProductDetail {
    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;

    public ProductDetailImpl(ProductRepository productRepository,
                             ProductVariantRepository productVariantRepository) {
        this.productRepository = productRepository;
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public ProductDetailResponseDTO getProductDetailById(Long productId) {
        Product product = productRepository.findById(productId);
        if (Objects.isNull(product))    return null;
        return ProductDetailResponseDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .description(product.getDescription())
                .images(product.getImages())
                .name(product.getName())
                .preOrder(product.getPreOrder())
                .productDimension(product.getProductDimension())
                .stockQuantity(product.getStockQuantity())
                .video(product.getVideo())
                .status(product.getStatus())
                .totalSold(product.getTotalSold())
                .displayPriority(product.getDisplayPriority())
                .tierVariations(product.getTierVariations())
                .tierVariations(new ArrayList<>())
                .build();
    }
}
