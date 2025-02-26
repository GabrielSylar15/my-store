package com.vinhnt.applicationservice.service.product;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductDetailResponseDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantCreation;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantCreationDTO;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductVariantApplicationService {
    private final ProductVariantCreation productVariantCreation;

    public ProductDetailResponseDTO createProductVariant(ProductVariantCreationDTO productVariantCreationDTO) {

    }
}
