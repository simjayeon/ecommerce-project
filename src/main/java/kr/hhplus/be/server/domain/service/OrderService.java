package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.entity.OrderItem;
import kr.hhplus.be.server.domain.repository.IOrderItemRepository;
import kr.hhplus.be.server.domain.repository.IOrderRepository;
import kr.hhplus.be.server.infra.repository.OrderItemRepositoryImpl;
import kr.hhplus.be.server.interfaces.dto.request.OrderRequest;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderItemRepositoryImpl orderItemRepository;

    public ResponseEntity<OrderResponse> getOrderDetails(Long userId, Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findAllByOrderId(orderId);

        return ResponseEntity.ok(OrderResponse.builder()
                .id(orderId)
                .orderedAt(LocalDateTime.now())
                .userId(userId)
                .userName("홍길동")
//                .products(new ArrayList<>(List.of(
//                        ProductResponse.builder()
//                                .id(1L)
//                                .name("상품1")
//                                .price(1000)
//                                .stock(10)
//                                .build(),
//                        ProductResponse.builder()
//                                .id(2L)
//                                .name("상품2")
//                                .price(2000)
//                                .stock(20)
//                                .build()
//                )))
                .build());
    }

    public ResponseEntity<Boolean> createOrder(OrderRequest req) {
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Boolean> cancelOrder(Long orderId) {
        return ResponseEntity.ok(true);
    }
}
