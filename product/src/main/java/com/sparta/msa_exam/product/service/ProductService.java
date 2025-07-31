package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.RequestProduct;
import com.sparta.msa_exam.product.dto.ResponseProduct;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ResponseProduct saveProduct(RequestProduct requestProduct) {
        Product product = Product.builder()
                .name(requestProduct.getName())
                .price(requestProduct.getSupply_price())
                .build();

        Product savedProduct = productRepository.save(product);

        return ResponseProduct.builder()
                .productId(savedProduct.getProductId())
                .name(savedProduct.getName())
                .supply_price(savedProduct.getPrice())
                .build();
    }
}
