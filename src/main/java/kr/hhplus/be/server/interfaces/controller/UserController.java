package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kr.hhplus.be.server.infra.service.UserService;
import kr.hhplus.be.server.interfaces.dto.request.LoginRequest;
import kr.hhplus.be.server.interfaces.dto.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    @Operation(summary = "createUser", description = "회원가입")
    public void createUser(@RequestBody @Valid SignupRequest signupRequest,
                           BindingResult bindingResult) {
        userService.createUser(signupRequest, bindingResult);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest,
                                   BindingResult bindingResult) {
        return userService.loginUser(loginRequest, bindingResult);
    }
}
