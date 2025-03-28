package kr.hhplus.be.server.interfaces.dto.request;


public record CouponRequest(
        Long userId,
        String couponCode
) {
}
