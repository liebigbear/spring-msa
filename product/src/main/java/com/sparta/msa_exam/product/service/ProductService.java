package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.RequestProduct;
import com.sparta.msa_exam.product.dto.ResponseProduct;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    //상품 등록
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

    //상품 목록 조회
    public List<ResponseProduct> getProducts(List<Long> ids) {
        List<Product> products = productRepository.findAllById(ids);

        return products.stream()
                .map(product -> ResponseProduct.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .supply_price(product.getPrice())
                        .build()
                ).collect(Collectors.toList());
    }
}
