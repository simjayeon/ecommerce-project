package kr.hhplus.be.server.interfaces.dto.request;


public record RechargeRequest(
        Long userId,
        Integer amount
) {
}
