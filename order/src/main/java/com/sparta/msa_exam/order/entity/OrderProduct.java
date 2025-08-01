package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    private Long productId;
    private int quantity;
    private Integer price;

    @Builder
    public OrderProduct(Orders orders, Long productId, int quantity, Integer price) {
        this.orders = orders;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
