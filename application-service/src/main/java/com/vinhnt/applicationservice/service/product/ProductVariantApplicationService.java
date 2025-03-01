package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.*;
import com.vinhnt.common.util.JsonUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductVariantApplicationService {
    private final ProductVariantCreation productVariantCreation;
    private final ProductVariantUpdate productVariantUpdate;
    private final ProductDetail productDetail;

    @Transactional
    public ProductDetailResponseDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) {
        ProductVariantCreationOutputDTO productVariantCreationOutputDTO = productVariantCreation.createProductVariant(productVariantCreationDTO);
        ProductDetailResponseDTO productDetailResponseDTO = productDetail.getProductDetailById(productVariantCreationDTO.productId());
        productDetailResponseDTO.setProductVariants(productVariantCreationOutputDTO.variants().stream().map(ProductVariantDTO::fromProductVariant).toList());
        productDetailResponseDTO.setTierVariants(productVariantCreationOutputDTO.tierVariations());
        JsonUtil.stringify(productDetailResponseDTO);
        return productDetailResponseDTO;
    }

    @Transactional
    public ProductDetailResponseDTO updateProductVariant(ProductVariantUpdateDTO productVariantUpdateDTO) {

    }
}
