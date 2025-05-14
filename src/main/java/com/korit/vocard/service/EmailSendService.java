package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.utils.SendTemporaryPasswordEmailResponseDto;
import com.korit.vocard.common.dto.response.utils.SendVerificationEmailResponseDto;

/**
 * interface: 이메일 발송 서비스
 * 
 * description: 이메일 전송 관련 기능을 정의합니다.
 */
public interface EmailSendService {
  
  /**
   * description: 인증 코드 이메일 발송
   *
   * @param email 수신자 이메일
   * @param code 인증 코드
   * @return 이메일 발송 결과가 포함된 응답
   */
  ResponseEntity<? super SendVerificationEmailResponseDto> sendVerificationEmail(String email, Integer code);
  
  /**
   * description: 임시 비밀번호 이메일 발송
   *
   * @param email 수신자 이메일
   * @param temporaryPassword 임시 비밀번호
   * @return 이메일 발송 결과가 포함된 응답
   */
  ResponseEntity<? super SendTemporaryPasswordEmailResponseDto> sendTemporaryPasswordEmail(String email, String temporaryPassword);
} 