package com.korit.vocard.common.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * class: 비밀번호 재설정 요청 DTO
 * 
 * description: 비밀번호 재설정을 위한 이메일 정보를 담는 DTO입니다.
 * 
 * <p>유효성 검증 실패 시 {@link com.korit.vocard.handler.CustomExceptionHandler#validExceptionHandler}에서
 * {@code validation fail} 응답을 반환합니다.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordRequestDto {
    
    /**
     * description: 비밀번호를 재설정할 사용자 이메일
     * 
     * <p>유효성 검증:
     * <ul>
     * <li>{@code @NotBlank}: 필수 입력값</li>
     * <li>{@code @Email}: 이메일 형식 검증</li>
     * </ul>
     * </p>
     * 
     * @see jakarta.validation.constraints.NotBlank
     * @see jakarta.validation.constraints.Email
     */
    @NotBlank
    @Email
    private String email;
}