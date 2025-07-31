package com.sparta.msa_exam.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseProduct {

    private final Long productId;

    private final String name;

    private final Integer supply_price;

}
