package kr.hhplus.be.server.interfaces.controller;

import kr.hhplus.be.server.domain.service.UserTransactionService;
import kr.hhplus.be.server.interfaces.dto.request.RechargeRequest;
import kr.hhplus.be.server.interfaces.dto.response.UserTransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class UserTransactionController {

    private final UserTransactionService userTransactionService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserTransactionResponse>> getUserTransactions(@PathVariable Long userId) {
        return userTransactionService.getUserTransactions(userId);
    }

    @PostMapping("")
    public ResponseEntity<Boolean> recharge(@RequestBody RechargeRequest req) {
        return userTransactionService.recharge(req);
    }

}
