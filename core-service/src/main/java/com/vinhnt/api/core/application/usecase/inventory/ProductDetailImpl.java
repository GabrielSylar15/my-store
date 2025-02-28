package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductRepository;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<ProductVariant> productVariants = productVariantRepository.findByProductIdAndStatus(productId, ProductVariantStatus.AVAILABLE);
        return ProductDetailResponseDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .description(product.getDescription())
                .images(product.getImages().stream().map(ImageDTO::fromImage).collect(Collectors.toList()))
                .name(product.getName())
                .preOrder(PreOrderDTO.fromPreOrder(product.getPreOrder()))
                .productDimension(product.getProductDimension())
                .stockQuantity(product.getStockQuantity())
                .video(VideoDTO.fromVideo(product.getVideo()))
                .status(product.getStatus())
                .totalSold(product.getTotalSold())
                .displayPriority(product.getDisplayPriority())
                .priceInfo(ProductPriceInfoDTO.fromProductPriceInfo(product.getPriceInfo()))
                .productVariants(productVariants.stream().map(ProductVariantDTO::fromProductVariant).collect(Collectors.toList()))
                .tierVariations(product.getTierVariations())
                .build();
    }
}
