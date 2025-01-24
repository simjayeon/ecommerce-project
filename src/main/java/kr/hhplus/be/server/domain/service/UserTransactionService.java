package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.interfaces.dto.request.RechargeRequest;
import kr.hhplus.be.server.interfaces.dto.response.UserTransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTransactionService {

    public ResponseEntity<List<UserTransactionResponse>> getUserTransactions(Long userId) {
        return ResponseEntity.ok(List.of());
    }

    public ResponseEntity<Boolean> recharge(RechargeRequest req) {
        return ResponseEntity.ok(true);
    }
}
