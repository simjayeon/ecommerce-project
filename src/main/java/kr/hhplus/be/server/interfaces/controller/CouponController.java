package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/{userId}")
    @Operation(summary = "createCoupon", description = "쿠폰 생성")
    public ResponseEntity<Boolean> createCoupon(@PathVariable Long userId,
                                                @RequestParam String couponCode) {
        return couponService.createCoupon(userId, couponCode);
    }

}
