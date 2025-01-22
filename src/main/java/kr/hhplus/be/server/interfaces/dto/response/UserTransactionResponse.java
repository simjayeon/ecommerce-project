package kr.hhplus.be.server.interfaces.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserTransactionResponse(
        Long id,
        String name,
        Integer price,
        String code,
        Double discountRate,
        String status,
        LocalDateTime startAt,
        LocalDateTime endAt
) {
}
