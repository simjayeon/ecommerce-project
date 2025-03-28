package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "필수 입력 값입니다.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "필수 입력 값입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "필수 입력 값입니다.")
    @Size(min = 6, message = "최소 6자 이상 입력하세요.")
    @Column(name = "password")
    private String password;

}
