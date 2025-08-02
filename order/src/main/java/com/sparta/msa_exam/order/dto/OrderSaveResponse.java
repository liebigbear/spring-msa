package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.entity.Orders;
import jakarta.persistence.Access;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class OrderSaveResponse {
    private Long orderId;
    private List<Long> productIds;

    public static OrderSaveResponse fromOrder(final Orders orders) {
        return OrderSaveResponse.builder()
                .orderId(orders.getOrderId())
                .productIds(orders.getOrderProducts().stream().map(OrderProduct::getProductId).collect(Collectors.toList()))
                .build();
    }
}
