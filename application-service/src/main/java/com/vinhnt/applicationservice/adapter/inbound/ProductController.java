package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductCreationDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductUpdateInfoDTO;
import com.vinhnt.applicationservice.service.product.ProductApplicationService;
import com.vinhnt.common.dto.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductApplicationService productApplicationService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreationDTO productCreationDTO) {
        return ResponseEntity.ok(ResponseBuilder.success(productApplicationService.createProduct(productCreationDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdateInfoDTO productUpdateInfoDTO,
                                           @PathVariable("id") long id) {
        productUpdateInfoDTO = new ProductUpdateInfoDTO(id, productUpdateInfoDTO.categoryId(), productUpdateInfoDTO.description(), productUpdateInfoDTO.images(), productUpdateInfoDTO.name(), productUpdateInfoDTO.preOrder(), productUpdateInfoDTO.productDimension(), productUpdateInfoDTO.stockQuantity(), productUpdateInfoDTO.displayPriority(), productUpdateInfoDTO.video());
        return ResponseEntity.ok(ResponseBuilder.success(productApplicationService.updateProduct(productUpdateInfoDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(ResponseBuilder.success(productApplicationService.getProductById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(ResponseBuilder.success(""));
    }
}
