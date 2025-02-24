package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductCreationDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductDetailResponseDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductUpdate;
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

    public JPAProduct updateProduct(Product product) {
        return null;
    }

    public JPAProduct getProductById(long id) {
        return null;
    }

    public void deleteProduct(long id) {

    }


}
