package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderSaveRequest;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;


    public void saveOrder(OrderSaveRequest requestDto) {

        // TODO: 1. RestTemplate을 사용하여 Product 서비스에서 상품 정보 조회 (MSA 통신)
        // - 요청 DTO에서 상품 ID 목록을 추출합니다.
        // - RestTemplate으로 product 서비스의 'GET /products?ids=...' API를 호출합니다.

        // TODO: 2. 비즈니스 로직 처리
        // - 조회된 상품 정보를 바탕으로 주문 총액을 계산합니다.
        // - 재고 확인 및 차감 로직이 필요하다면 여기에 구현합니다.

        // TODO: 3. Order 및 OrderProduct 엔티티 생성
        // - 계산된 총액으로 Order 엔티티를 빌더 패턴으로 생성합니다.
        // - 요청된 상품 목록(items)을 순회하며 OrderProduct 엔티티를 생성하고, Order에 추가합니다.
    }
}