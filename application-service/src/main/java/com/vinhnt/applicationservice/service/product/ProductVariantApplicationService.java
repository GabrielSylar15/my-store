package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.common.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductVariantApplicationService {
    private final ProductVariantCreation productVariantCreation;
    private final ProductDetail productDetail;

    public ProductDetailResponseDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) {
        ProductVariantCreationOutputDTO productVariantCreationOutputDTO = productVariantCreation.createProductVariant(productVariantCreationDTO);
        ProductDetailResponseDTO productDetailResponseDTO = productDetail.getProductDetailById(productVariantCreationDTO.productId());
        productDetailResponseDTO.setProductVariants(productVariantCreationOutputDTO.variants());
        productDetailResponseDTO.setTierVariants(productVariantCreationOutputDTO.tierVariations());
        JsonUtil.stringify(productDetailResponseDTO);
        return productDetailResponseDTO;
    }
}
