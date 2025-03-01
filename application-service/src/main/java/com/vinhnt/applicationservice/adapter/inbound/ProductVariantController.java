package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantCreationDTO;
import com.vinhnt.applicationservice.service.product.ProductVariantApplicationService;
import com.vinhnt.common.dto.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product-variants")
public class ProductVariantController {
    public final ProductVariantApplicationService productVariantApplicationService;

    @PostMapping("")
    public ResponseEntity<?> createProductVariant(@RequestBody ProductVariantCreationDTO productVariantCreationDTO) {
        return ResponseEntity.ok(ResponseBuilder.success(productVariantApplicationService.createProductVariant(productVariantCreationDTO)));
    }

    @PutMapping("")
    public ResponseEntity<?> updateProductVariant(@RequestBody ProductVariantCreationDTO productVariantCreationDTO) {

    }

    @PostMapping("/add-item")
    public ResponseEntity<?> addItem(@RequestBody ProductVariantCreationDTO productVariantCreationDTO) {

    }
}
