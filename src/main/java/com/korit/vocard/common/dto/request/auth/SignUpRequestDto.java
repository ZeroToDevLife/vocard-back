package com.korit.vocard.common.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * class: 회원가입 요청 DTO
 * 
 * description: 사용자의 회원가입 요청 정보를 담는 DTO입니다.
 * {@link com.example.nihongo.common.entity.UserEntity} 생성에 사용됩니다.
 * 
 * <p>유효성 검증 실패 시 {@link com.korit.vocard.handler.CustomExceptionHandler#validExceptionHandler}에서
 * {@code validation fail} 응답을 반환합니다.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    /**
     * description: 사용자 이메일 주소
     * 
     * <p>유효성 검증:
     * <ul>
     * <li>{@code @NotBlank}: 필수 입력값</li>
     * <li>{@code @Email}: 이메일 형식 검증</li>
     * <li>{@link jakarta.persistence.Column#unique()}: 중복 가입 불가</li>
     * </ul>
     * </p>
     * 
     * @see jakarta.validation.constraints.NotBlank
     * @see jakarta.validation.constraints.Email
     */
    @NotBlank
    @Email
    private String email;

    /**
     * description: 사용자 비밀번호
     * 
     * <p>유효성 검증:
     * <ul>
     * <li>{@code @NotBlank}: 필수 입력값</li>
     * <li>{@code @Pattern}: 비밀번호 규칙
     *   <ul>
     *   <li>길이: {@code 8~20}자</li>
     *   <li>첫 글자: 반드시 영문</li>
     *   <li>필수 포함: 영문, 숫자</li>
     *   <li>선택 포함: 특수문자({@code !@#$%^&*})</li>
     *   </ul>
     * </li>
     * </ul>
     * </p>
     * 
     * <p>보안:
     * {@link org.springframework.security.crypto.password.PasswordEncoder}를 통해 암호화됨
     * </p>
     */
    @NotBlank
    @Pattern(regexp = "^(?=[a-zA-Z])(?=.*\\d)[a-zA-Z\\d!@#$%^&*]{8,20}$")
    private String password;

    /**
     * description: 사용자 닉네임
     * 
     * <p>유효성 검증:
     * <ul>
     * <li>{@code @NotBlank}: 필수 입력값</li>
     * <li>{@code @Pattern}: 닉네임 규칙
     *   <ul>
     *   <li>길이: {@code 3~20}자</li>
     *   <li>첫 글자: 반드시 영문</li>
     *   <li>포함: 영문, 숫자만 허용</li>
     *   </ul>
     * </li>
     * </ul>
     * </p>
     */
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\d]{2,19}$")
    private String nickname;
}
