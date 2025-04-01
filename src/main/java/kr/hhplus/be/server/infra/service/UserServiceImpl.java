package kr.hhplus.be.server.infra.service;

import jakarta.validation.Valid;
import kr.hhplus.be.server.config.util.JwtUtil;
import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.infra.repository.UserRepository;
import kr.hhplus.be.server.interfaces.dto.request.LoginRequest;
import kr.hhplus.be.server.interfaces.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void createUser(SignupRequest signupRequest, BindingResult bindingResult) {
        validateAuthRequest(bindingResult);
        Optional<User> optUser = userRepository.findByEmail(signupRequest.email());
        if (optUser.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일 주소입니다.");
        }
        registerUser(signupRequest);
    }

    @Override
    public ResponseEntity<?> loginUser(LoginRequest loginRequest, BindingResult bindingResult) {
        validateAuthRequest(bindingResult);
        String token = authenticateUser(loginRequest);
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    private void validateAuthRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorMessages);
        }
    }

    private void registerUser(SignupRequest signupRequest) {
        User user = User.builder()
                .name(signupRequest.name())
                .email(signupRequest.email())
                .password(passwordEncoder.encode(signupRequest.password()))
                .build();
        userRepository.save(user);
    }

    private String authenticateUser(LoginRequest loginRequest) {
        Optional<User> optUser = userRepository.findByEmail(loginRequest.email());
        if (optUser.isEmpty()) {
            throw new IllegalArgumentException("가입되지 않은 이메일 주소입니다.");
        }

        User user = optUser.get();
        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // JWT 발급 후 반환
        return jwtUtil.generateToken(user.getEmail());
    }
}