package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.RequestProduct;
import com.sparta.msa_exam.product.dto.ResponseProduct;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ResponseProduct> saveProduct(@RequestBody RequestProduct product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }
}
