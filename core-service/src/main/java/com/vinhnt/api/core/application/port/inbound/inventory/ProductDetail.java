package com.vinhnt.api.core.application.port.inbound.inventory;

public interface ProductDetail {
    ProductDetailResponseDTO getProductDetailById(Long productId);
}
