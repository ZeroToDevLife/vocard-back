package com.korit.vocard.common.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * class: 이메일 인증 코드 확인 요청 DTO
 * 
 * description: 사용자가 입력한 이메일 인증 코드의 유효성을 확인하는 요청에 사용되는 DTO입니다.
 * 이메일은 인증 토큰에서 추출합니다.
 * 
 * <p>유효성 검증 실패 시 {@link com.korit.vocard.handler.CustomExceptionHandler#validExceptionHandler}에서
 * {@code validation fail} 응답을 반환합니다.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailAuthVerifyRequestDto {

  /**
   * description: 사용자가 입력한 인증 코드
   * 
   * <p>유효성 검증:
   * <ul>
   * <li>{@code @NotBlank}: 필수 입력값</li>
   * <li>{@code @Pattern}: 6자리 숫자</li>
   * </ul>
   * </p>
   * 
   * @see jakarta.validation.constraints.NotBlank
   * @see jakarta.validation.constraints.Pattern
   */
  @NotBlank
  @Pattern(regexp = "^[0-9]{6}$")
  private String code;
}
