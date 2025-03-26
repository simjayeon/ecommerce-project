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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public OrderResponse findOrderItemsByOrderId(Long userId, Long orderId) {
        Optional<Order> order = orderRepository.findOrderWithUserAndItemsAndProduct(orderId);

        if (order.isPresent()) {
            List<ProductResponse> productResponses = order.get().getOrderItems()
                    .stream()
                    .map(orderItem -> ProductResponse.of(orderItem.getProduct()))
                    .collect(Collectors.toList());

            return OrderResponse.of(order.get(), productResponses);
        } else {
            throw new EntityNotFoundException("Order not found with ID: " + orderId);
        }
    }
}
