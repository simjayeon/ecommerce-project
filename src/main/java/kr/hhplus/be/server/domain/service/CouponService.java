package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.interfaces.dto.request.CouponRequest;
import kr.hhplus.be.server.interfaces.dto.response.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    public ResponseEntity<List<CouponResponse>> getCoupons() {
        return ResponseEntity.ok(List.of(
                CouponResponse.builder()
                        .id(1L)
                        .name("10% 할인 쿠폰")
                        .discountRate(0.1)
                        .build(),
                CouponResponse.builder()
                        .id(2L)
                        .name("20% 할인 쿠폰")
                        .discountRate(0.2)
                        .build()
        ));
    }

    public ResponseEntity<List<CouponResponse>> getUserCoupons(Long userId) {
        return ResponseEntity.ok(List.of(
                CouponResponse.builder()
                        .id(1L)
                        .name("10% 할인 쿠폰")
                        .discountRate(0.1)
                        .build()
        ));
    }

    public ResponseEntity<Boolean> createCoupon(CouponRequest couponRequest) {
        return ResponseEntity.ok(true);
    }

}
