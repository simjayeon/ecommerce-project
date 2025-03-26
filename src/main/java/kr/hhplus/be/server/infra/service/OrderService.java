package kr.hhplus.be.server.infra.service;


import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;

public interface OrderService {

    OrderResponse findOrderItemsByOrderId(Long userId, Long orderId);
}
