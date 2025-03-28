package kr.hhplus.be.server.interfaces.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @NotBlank(message = "필수 입력 값입니다.")
        String name,

        @NotBlank(message = "필수 입력 값입니다.")
        @Email(message = "유효한 이메일 주소를 입력하세요.")
        String email,

        @NotBlank(message = "필수 입력 값입니다.")
        @Size(min = 6, message = "최소 6자 이상 입력하세요.")
        String password
) {
}
