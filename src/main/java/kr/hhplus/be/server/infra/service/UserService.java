package kr.hhplus.be.server.infra.service;


import kr.hhplus.be.server.interfaces.dto.request.SignupRequest;
import org.springframework.validation.BindingResult;

public interface UserService {
    void createUser(SignupRequest req, BindingResult bindingResult);
}
