package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderSaveRequest;
import com.sparta.msa_exam.order.dto.OrderSaveResponse;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderSaveResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest) {
        return ResponseEntity.ok(orderService.saveOrder(orderSaveRequest));
    }
}
