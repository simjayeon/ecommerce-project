package kr.hhplus.be.server.infra.service;


import kr.hhplus.be.server.interfaces.dto.request.LoginRequest;
import kr.hhplus.be.server.interfaces.dto.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface UserService {
    void createUser(SignupRequest signupRequest, BindingResult bindingResult);

    ResponseEntity<?> loginUser(LoginRequest loginRequest, BindingResult bindingResult);
}
