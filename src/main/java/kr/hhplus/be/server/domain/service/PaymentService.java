package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.interfaces.dto.request.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class PaymentService {

    public ResponseEntity<Boolean> executePayment(PaymentRequest req) {
        return ResponseEntity.ok(true);
    }
}
