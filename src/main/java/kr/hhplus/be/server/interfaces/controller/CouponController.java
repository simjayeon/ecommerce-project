package kr.hhplus.be.server.interfaces.controller;

import kr.hhplus.be.server.domain.service.CouponService;
import kr.hhplus.be.server.interfaces.dto.response.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/")
    public ResponseEntity<List<CouponResponse>> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CouponResponse>> getUserCoupons(@PathVariable Long userId) {
        return couponService.getUserCoupons(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Boolean> createCoupon(@PathVariable Long userId,
                                                @RequestParam String couponCode) {
        return couponService.createCoupon(userId, couponCode);
    }

}
