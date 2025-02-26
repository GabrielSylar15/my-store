package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductApplicationService {
    private final ProductCreation productCreation;
    private final ProductUpdate productUpdate;
    private final ProductDetail productDetail;

    public ProductDetailResponseDTO createProduct(ProductCreationDTO productCreationDTO) {
        Product product = productCreation.createProduct(productCreationDTO);
        return getProductDetailResponseDTO(product);
    }

    public ProductDetailResponseDTO updateProduct(ProductUpdateInfoDTO productUpdateInfoDTO) {
        Product product = productUpdate.updateProductInfo(productUpdateInfoDTO);
        return getProductDetailResponseDTO(product);
    }

    private ProductDetailResponseDTO getProductDetailResponseDTO(Product product) {
        if (Objects.isNull(product)) return null;
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
                .build();
    }

    public ProductDetailResponseDTO getProductById(long id) {
        return productDetail.getProductDetailById(id);
    }

    public void deleteProduct(long id) {

    }


}
