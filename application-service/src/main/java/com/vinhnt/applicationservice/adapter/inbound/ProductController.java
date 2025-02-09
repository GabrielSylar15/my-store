package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.domain.model.inventory.Product;
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
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(ResponseBuilder.success(productApplicationService.createProduct(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           @PathVariable("id") Long id) {

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {

    }
}
