package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.applicationservice.service.product.ProductVariantApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product-variants")
public class ProductVariantController {
    public ProductVariantApplicationService productVariantApplicationService;

    @PostMapping("")
    public ResponseEntity<?> createProductVariant(@RequestBody ProductVariant productVariant) {
        productVariantApplicationService.
    }
}
