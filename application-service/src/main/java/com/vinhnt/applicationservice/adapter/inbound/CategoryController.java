package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.application.port.inbound.product.CategoryCreationDTO;
import com.vinhnt.applicationservice.service.product.CategoryApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryApplicationService categoryApplicationService;

    @PostMapping()
    public ResponseEntity<?> addCategory(@RequestBody CategoryCreationDTO categoryCreationDTO) {
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryCreationDTO categoryCreationDTO) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {

    }
}
