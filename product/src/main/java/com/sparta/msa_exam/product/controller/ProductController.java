package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.RequestProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    @PostMapping("/products")
    public ResponseEntity<RequestProduct> saveProduct(@RequestBody RequestProduct product) {
        return ResponseEntity.ok(product);
    }
}
