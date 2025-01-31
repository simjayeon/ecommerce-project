package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.service.CouponService;
import kr.hhplus.be.server.interfaces.dto.request.CouponRequest;
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

    @GetMapping("")
    @Operation(summary = "getCoupons", description = "쿠폰 목록 조회")
    public ResponseEntity<List<CouponResponse>> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "getUserCoupons", description = "사용자 쿠폰 조회")
    public ResponseEntity<List<CouponResponse>> getUserCoupons(@PathVariable Long userId) {
        return couponService.getUserCoupons(userId);
    }

    @PostMapping("")
    @Operation(summary = "createCoupon", description = "쿠폰 생성")
    public ResponseEntity<Boolean> createCoupon(@RequestBody CouponRequest req) {
        return couponService.createCoupon(req);
    }

}
