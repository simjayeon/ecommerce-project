package kr.hhplus.be.server.interfaces.dto.request;


public record PaymentRequest(
        Long userId,
        Long orderId
) {
}
