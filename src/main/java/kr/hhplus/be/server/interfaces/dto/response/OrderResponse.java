package kr.hhplus.be.server.interfaces.dto.response;

import kr.hhplus.be.server.domain.entity.Order;
import kr.hhplus.be.server.domain.entity.OrderItem;
import lombok.Builder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResponse(
        Long id,
        Timestamp orderedAt,
        Long userId,
        String userName,
        List<ProductResponse> products
) {
    public static OrderResponse of(Order order, List<ProductResponse> productResponses) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderedAt(order.getOrderedAt())
                .userId(order.getUserId())
                .userName(order.getUser().getName())
                .products(productResponses)
                .build();
    }
}
