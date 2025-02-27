package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantCreationDTO;
import com.vinhnt.applicationservice.service.product.ProductVariantApplicationService;
import com.vinhnt.common.dto.ResponseBuilder;
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
    public final ProductVariantApplicationService productVariantApplicationService;

    @PostMapping("")
    public ResponseEntity<?> createProductVariant(@RequestBody ProductVariantCreationDTO productVariantCreationDTO) {
        return ResponseEntity.ok(ResponseBuilder.success(productVariantApplicationService.createProductVariant(productVariantCreationDTO)));
    }
}
