package kr.hhplus.be.server.interfaces.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResponse(
        Long id,
        LocalDateTime orderedAt,
        Long userId,
        String userName,
        List<ProductResponse> products
) {
}
