package kr.hhplus.be.server.infra.repository;

import jakarta.persistence.EntityNotFoundException;
import kr.hhplus.be.server.domain.entity.Order;
import kr.hhplus.be.server.infra.service.OrderService;
import kr.hhplus.be.server.infra.jpa.OrderRepository;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    @Override
    public OrderResponse findOrderItemsByOrderId(Long userId, Long orderId) {
        Order order = orderRepository.findOrderWithUserAndItemsAndProduct(userId, orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID and User ID: " + orderId + "/" + userId));

        List<ProductResponse> productResponses = order.getOrderItems().stream()
                .map(orderItem -> ProductResponse.of(orderItem.getProduct()))
                .collect(Collectors.toList());

        return OrderResponse.of(order, productResponses);
    }
}
