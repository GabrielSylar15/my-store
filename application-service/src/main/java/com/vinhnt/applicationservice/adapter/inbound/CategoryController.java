package com.vinhnt.applicationservice.adapter.inbound;

import com.vinhnt.api.core.application.port.inbound.inventory.CategoryCreationDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.CategoryUpdateDTO;
import com.vinhnt.applicationservice.service.product.CategoryApplicationService;
import com.vinhnt.common.dto.ResponseBuilder;
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
        return ResponseEntity.ok(ResponseBuilder.success(categoryApplicationService.createCategory(categoryCreationDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(ResponseBuilder.success(categoryApplicationService.getCategory(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        return ResponseEntity.ok(ResponseBuilder.success(categoryApplicationService.updateCategory(categoryUpdateDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok(ResponseBuilder.success(""));
    }
}
