package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.dto.OrderSaveRequest;
import com.sparta.msa_exam.order.dto.OrderSaveResponse;
import com.sparta.msa_exam.order.dto.ProductResponse;
import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.entity.Orders;
import com.sparta.msa_exam.order.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    //주문 추가 API 호출 실패
    public OrderSaveResponse fallbackSaveOrder(OrderSaveRequest orderSaveRequest, Throwable throwable) {
        String message = "잠시 후에 주문 추가를 요청 해주세요.";
        return OrderSaveResponse.error(message);
    }

    // 주문 추가 메서드
    @CircuitBreaker(name = "order", fallbackMethod = "fallbackSaveOrder")
    @Transactional
    public OrderSaveResponse saveOrder(OrderSaveRequest requestDto) {

        // Product 서비스에서 상품 정보 조회 (MSA 통신)
        List<ProductResponse> productResponses = productClient.getProductByIds(requestDto.getOrderIds());

        // Order 및 OrderProduct 엔티티 생성
        Orders order = new Orders(new ArrayList<>());

        productResponses.forEach(product -> {
            OrderProduct orderProduct = OrderProduct.builder()
                    .productId(product.getProductId())
                    .build();
            order.addOrderProduct(orderProduct);
        });

        orderRepository.save(order);
        return OrderSaveResponse.fromOrder(order);
    }
}