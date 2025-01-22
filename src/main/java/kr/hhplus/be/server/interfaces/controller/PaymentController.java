package kr.hhplus.be.server.interfaces.controller;

import kr.hhplus.be.server.domain.service.PaymentService;
import kr.hhplus.be.server.interfaces.dto.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<Boolean> executePayment(@RequestBody PaymentRequest req) {
        return paymentService.executePayment(req);
    }

}
