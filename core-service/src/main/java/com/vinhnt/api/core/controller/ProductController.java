package com.vinhnt.api.core.controller;

import com.vinhnt.common.dto.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ProductController {
    @GetMapping("product")
    public ResponseEntity<?> get(@RequestParam("id") Long id) {
        return ResponseEntity.ok(ResponseBuilder.success(String.format("Hello %d", id)));
    }
}
