package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.request.auth.EmailCheckRequestDto;
import com.korit.vocard.common.dto.request.auth.ResetPasswordRequestDto;
import com.korit.vocard.common.dto.request.auth.SignInRequestDto;
import com.korit.vocard.common.dto.request.auth.SignOutRequestDto;
import com.korit.vocard.common.dto.request.auth.SignUpRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.auth.SignInResponseDto;

/**
 * interface: 인증 서비스 인터페이스
 * 
 * description: 회원가입, 로그인, 이메일 중복 확인 등의 인증 관련 기능을 정의합니다.
 */
public interface AuthService {

  /**
   * description: 로그인 처리
   *
   * @param dto {@link SignInRequestDto} 로그인 요청 정보
   * @return 성공 시 {@link SignInResponseDto}, 실패 시 {@code sign in fail} 응답
   */
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

  /**
   * description: 회원가입 처리
   *
   * @param dto {@link SignUpRequestDto} 회원가입 요청 정보
   * @return 성공 시 {@link HttpStatus#CREATED} (201), 실패 시 오류 응답
   */
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);

    /**
   * description: 이메일 중복 확인
   *
   * @param dto {@link EmailCheckRequestDto} 이메일 중복 확인 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  ResponseEntity<ResponseDto> emailCheck(EmailCheckRequestDto dto);

  /**
   * description: 비밀번호 재설정
   *
   * @param dto {@link ResetPasswordRequestDto} 비밀번호 재설정 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  ResponseEntity<ResponseDto> resetPassword(ResetPasswordRequestDto dto);

  /**
   * description: 로그아웃 처리
   *
   * @param dto {@link SignOutRequestDto} 로그아웃 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  ResponseEntity<ResponseDto> signOut(SignOutRequestDto dto);
}