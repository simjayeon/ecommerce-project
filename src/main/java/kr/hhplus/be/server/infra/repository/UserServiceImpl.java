package kr.hhplus.be.server.infra.repository;

import jakarta.validation.Valid;
import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.infra.jpa.UserRepository;
import kr.hhplus.be.server.infra.service.UserService;
import kr.hhplus.be.server.interfaces.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(SignupRequest signupRequest, BindingResult bindingResult) {
        // 유효성 검사
        validateSignupRequest(signupRequest, bindingResult);

        // 회원가입 처리
        registerUser(signupRequest);
    }

    private void validateSignupRequest(@Valid SignupRequest signupRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류가 있다면, 오류 메시지를 반환
            String errorMessages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorMessages);
        }

        Optional<User> optUser = userRepository.findByEmail(signupRequest.email());
        if (optUser.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일 주소입니다.");
        }
    }

    private void registerUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.name());
        user.setEmail(signupRequest.email());
        user.setPassword(passwordEncoder.encode(signupRequest.password()));
        userRepository.save(user);
    }
}