package com.sparta.msa_exam.product.dto;

import lombok.Getter;

@Getter
public class RequestProduct {
    private final String name;
    private final Integer supply_price;


    public RequestProduct(String name, Integer supplyPrice) {
        this.name = name;
        this.supply_price = supplyPrice;
    }
}
