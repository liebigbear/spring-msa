package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.RequestProduct;
import com.sparta.msa_exam.product.dto.ResponseProduct;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 추가 API
    @PostMapping("/products")
    public ResponseEntity<ResponseProduct> saveProduct(@RequestBody RequestProduct product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    //상품 목록 조회 API
    @GetMapping("/products")
    public ResponseEntity<List<ResponseProduct>> getAllProducts(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(productService.getProducts(ids));
    }
}
