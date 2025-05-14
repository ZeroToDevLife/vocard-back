package com.korit.vocard.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.request.auth.EmailAuthSendRequestDto;
import com.korit.vocard.common.dto.request.auth.EmailAuthVerifyRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.auth.EmailAuthResponseDto;
import com.korit.vocard.common.dto.response.utils.SendVerificationEmailResponseDto;
import com.korit.vocard.common.entity.EmailAuthEntity;
import com.korit.vocard.common.entity.UserEntity;
import com.korit.vocard.common.util.RandomUtils;
import com.korit.vocard.repository.EmailAuthRepository;
import com.korit.vocard.repository.UserRepository;
import com.korit.vocard.service.EmailAuthService;
import com.korit.vocard.service.EmailSendService;

import lombok.RequiredArgsConstructor;

/**
 * class: 이메일 인증 서비스 구현체
 * 
 * description: 이메일 인증 코드 발송 및 검증 기능을 구현합니다.
 */
@Service
@RequiredArgsConstructor
public class EmailAuthServiceImplement implements EmailAuthService {

  private final EmailAuthRepository emailAuthRepository;
  private final UserRepository userRepository;
  private final EmailSendService emailSendService;

  /**
   * description: 이메일 인증 코드 발송
   * 
   * <p>
   * <ul>
   * <li>6자리 랜덤 인증 코드 생성</li>
   * <li>이메일 인증 정보 저장 또는 업데이트</li>
   * <li>인증 코드 이메일 발송</li>
   * </ul>
   * </p>
   *
   * @param dto {@link EmailAuthSendRequestDto} 이메일 인증 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  @Override
  public ResponseEntity<ResponseDto> sendEmail(EmailAuthSendRequestDto dto, String email) {

    // RandomUtils를 사용하여 6자리 인증 코드 생성 (100000~999999)
    Integer code = RandomUtils.randomNumber(100000, 999999);

    try {
      ResponseEntity<? super SendVerificationEmailResponseDto> emailResponse = 
          emailSendService.sendVerificationEmail(email, code);
      
      if (!emailResponse.getStatusCode().is2xxSuccessful()) {
        return ResponseDto.emailSendError();
      }

      // 인증 코드 저장
      EmailAuthEntity emailAuthEntity = new EmailAuthEntity(
        email,
        code
      );
        
      emailAuthRepository.save(emailAuthEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);
  }

  /**
   * description: 이메일 인증 코드 검증
   * 
   * <p>
   * <ul>
   * <li>이메일로 인증 정보 조회</li>
   * <li>인증 코드 일치 여부 확인</li>
   * <li>인증 상태 업데이트</li>
   * </ul>
   * </p>
   *
   * @param dto {@link EmailAuthResponseDto} 이메일 인증 코드 검증 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 {@code auth code not match} 응답
   */
  @Override
  public ResponseEntity<? super EmailAuthResponseDto> verifyEmail(EmailAuthVerifyRequestDto dto, String email) {

    Integer code = Integer.valueOf(dto.getCode());
    UserEntity userEntity = null;

    try {
      EmailAuthEntity emailAuthEntity = emailAuthRepository.findByEmail(email);
      if (emailAuthEntity == null || !emailAuthEntity.getCode().equals(code)) {
        return ResponseDto.emailVerificationFail();
      }
   
      userEntity = userRepository.findByEmail(email);
      if (userEntity == null) return ResponseDto.validationFail();

      userEntity.setVerified(true);
      userRepository.save(userEntity);
        
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return EmailAuthResponseDto.success(userEntity.isVerified());
  }
}