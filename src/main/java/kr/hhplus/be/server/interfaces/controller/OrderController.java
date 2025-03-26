package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.infra.service.OrderService;
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
    @Operation(summary = "getOrderDetails", description = "주문 상세 조회")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable Long userId,
                                                         @PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findOrderItemsByOrderId(userId, orderId));
    }

//    @PostMapping("")
//    @Operation(summary = "createOrder", description = "주문 요청")
//    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest req) {
//        return orderService.createOrder(req);
//    }
//
//    @DeleteMapping("/{orderId}")
//    @Operation(summary = "cancelOrder", description = "주문 취소")
//    public ResponseEntity<Boolean> cancelOrder(@PathVariable Long orderId) {
//        return orderService.cancelOrder(orderId);
//    }

}
