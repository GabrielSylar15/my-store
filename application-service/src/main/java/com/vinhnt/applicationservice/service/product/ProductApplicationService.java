package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductApplicationService {
    private final ProductCreation productCreation;
    private final ProductUpdate productUpdate;

    public ProductDetailResponseDTO createProduct(ProductCreationDTO productCreationDTO) {
        Product product = productCreation.createProduct(productCreationDTO);
        return new ProductDetailResponseDTO(product.getTierVariations(),
                product.getId(),
                product.getCategoryId(),
                product.getDescription(),
                product.getImages(),
                product.getName(),
                product.getPreOrder(),
                product.getProductDimension(),
                product.getStockQuantity(),
                product.getVideo(),
                product.getStatus(),
                product.getTotalSold(),
                product.getDisplayPriority());
    }

    public ProductDetailResponseDTO updateProduct(ProductUpdateInfoDTO productUpdateInfoDTO) {
        Product product = productUpdate.updateProductInfo(productUpdateInfoDTO);
        return new ProductDetailResponseDTO(product.getTierVariations(),
                product.getId(),
                product.getCategoryId(),
                product.getDescription(),
                product.getImages(),
                product.getName(),
                product.getPreOrder(),
                product.getProductDimension(),
                product.getStockQuantity(),
                product.getVideo(),
                product.getStatus(),
                product.getTotalSold(),
                product.getDisplayPriority());
    }

    public JPAProduct getProductById(long id) {
        return null;
    }

    public void deleteProduct(long id) {

    }


}
