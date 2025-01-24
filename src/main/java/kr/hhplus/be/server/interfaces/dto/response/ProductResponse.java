package kr.hhplus.be.server.interfaces.dto.response;

import lombok.Builder;

@Builder
public record ProductResponse(
        Long id,
        String name,
        Integer price,
        Integer stock
) {
}
