package com.sparta.msa_exam.product.dto;

import lombok.Getter;

@Getter
public class ResponseProduct {
    private final Long productId;
    private final String name;
    private final Integer supply_price;


    public ResponseProduct(Long productId, String name, Integer supplyPrice) {
        this.productId = productId;
        this.name = name;
        supply_price = supplyPrice;
    }
}
