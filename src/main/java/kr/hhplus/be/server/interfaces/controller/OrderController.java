package kr.hhplus.be.server.interfaces.controller;

import kr.hhplus.be.server.domain.service.OrderService;
import kr.hhplus.be.server.interfaces.dto.request.OrderRequest;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable Long userId,
                                                         @PathVariable Long orderId) {
        return orderService.getOrderDetails(userId, orderId);
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest req) {
        return orderService.createOrder(req);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable Long orderId) {
        return orderService.cancelOrder(orderId);
    }

}
