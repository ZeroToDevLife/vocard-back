package com.korit.vocard.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.korit.vocard.common.dto.request.auth.EmailCheckRequestDto;
import com.korit.vocard.common.dto.request.auth.ResetPasswordRequestDto;
import com.korit.vocard.common.dto.request.auth.SignInRequestDto;
import com.korit.vocard.common.dto.request.auth.SignOutRequestDto;
import com.korit.vocard.common.dto.request.auth.SignUpRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.auth.SignInResponseDto;
import com.korit.vocard.common.dto.response.utils.GetTemporaryPasswordResponseDto;
import com.korit.vocard.common.dto.response.utils.SendTemporaryPasswordEmailResponseDto;
import com.korit.vocard.common.entity.UserEntity;
import com.korit.vocard.provider.JwtProvider;
import com.korit.vocard.repository.BlacklistTokenRepository;
import com.korit.vocard.repository.UserRepository;
import com.korit.vocard.service.AuthService;
import com.korit.vocard.service.EmailSendService;
import com.korit.vocard.service.PasswordCreateService;

import lombok.RequiredArgsConstructor;

/**
 * class: 인증 관련 서비스 구현체
 * 
 * description: 회원가입, 로그인, 이메일 중복 확인 등의 인증 관련 기능을 구현합니다.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;
  private final EmailSendService emailSendService;
  private final PasswordCreateService passwordCreateService;
  private final BlacklistTokenRepository blacklistTokenRepository;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /**
   * description: 로그인 처리
   * 
   * <p>
   * <ul>
   * <li>이메일로 사용자 조회</li>
   * <li>비밀번호 일치 여부 확인</li>
   * <li>JWT 토큰 생성</li>
   * </ul>
   * </p>
   *
   * @param dto {@link SignInRequestDto} 로그인 요청 정보
   * @return 성공 시 {@link SignInResponseDto}, 실패 시 {@code sign in fail} 응답
   */
  @Override
  public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

    String accessToken = null;
    UserEntity userEntity = null;

    try {
        
      String email = dto.getEmail();
      userEntity = userRepository.findByEmail(email);
      if (userEntity == null) return ResponseDto.signInFail();

      String password = dto.getPassword();
      String encodedPassword = userEntity.getPassword();
      boolean isMatch = passwordEncoder.matches(password, encodedPassword);
      if (!isMatch) return ResponseDto.signInFail();

      accessToken = jwtProvider.create(email);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return SignInResponseDto.success(accessToken, userEntity.isVerified());

  }

   /**
   * description: 회원가입 처리
   * 
   * <p>
   * <ul>
   * <li>이메일 중복 확인</li>
   * <li>비밀번호 암호화</li>
   * <li>사용자 정보 저장</li>
   * </ul>
   * </p>
   *
   * @param dto {@link SignUpRequestDto} 회원가입 요청 정보
   * @return 성공 시 {@link HttpStatus#CREATED} (201), 실패 시 오류 응답
   */
  @Override
  public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
    
    try {

      String email = dto.getEmail();
      boolean existEmail = userRepository.existsByEmail(email);
      if (existEmail) return ResponseDto.existEmail();

      String password = dto.getPassword();
      String encodedPassword = passwordEncoder.encode(password);
      dto.setPassword(encodedPassword);

      UserEntity userEntity = new UserEntity(dto);
      userRepository.save(userEntity);
        
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }

    /**
   * description: 이메일 중복 확인
   * 
   * <p>
   * <ul>
   * <li>이메일 존재 여부 확인</li>
   * <li>중복된 이메일이면 {@code exist email} 응답</li>
   * </ul>
   * </p>
   *
   * @param dto {@link EmailCheckRequestDto} 이메일 중복 확인 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  @Override
  public ResponseEntity<ResponseDto> emailCheck(EmailCheckRequestDto dto) {

    try {

      String email = dto.getEmail();
      boolean existEmail = userRepository.existsByEmail(email);
      if (existEmail) return ResponseDto.existEmail();
        
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);

  }
  
  /**
   * description: 비밀번호 재설정 구현
   * 
   * <p>
   * <ul>
   * <li>이메일로 사용자 조회</li>
   * <li>임시 비밀번호 생성 (영문 대소문자, 숫자, 특수문자 포함)</li>
   * <li>임시 비밀번호 이메일 전송</li>
   * <li>암호화된 비밀번호로 사용자 정보 업데이트</li>
   * </ul>
   * </p>
   *
   * @param dto {@link ResetPasswordRequestDto} 비밀번호 재설정 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  @Override
  public ResponseEntity<ResponseDto> resetPassword(ResetPasswordRequestDto dto) {
    try {
      String email = dto.getEmail();
      UserEntity userEntity = userRepository.findByEmail(email);
      if (userEntity == null) return ResponseDto.userNotExist();
      
      ResponseEntity<? super GetTemporaryPasswordResponseDto> passwordResponse = 
          passwordCreateService.generateTemporaryPassword();
      
      if (!passwordResponse.getStatusCode().is2xxSuccessful()) {
        return ResponseDto.databaseError();
      }
      
      GetTemporaryPasswordResponseDto passwordDto = (GetTemporaryPasswordResponseDto) passwordResponse.getBody();
      String temporaryPassword = passwordDto.getTemporaryPassword();
      
      ResponseEntity<? super SendTemporaryPasswordEmailResponseDto> emailResponse = 
          emailSendService.sendTemporaryPasswordEmail(email, temporaryPassword);
      
      if (!emailResponse.getStatusCode().is2xxSuccessful()) {
        return ResponseDto.emailSendError();
      }
      
      String encodedPassword = passwordEncoder.encode(temporaryPassword);
      userEntity.setPassword(encodedPassword);
      userRepository.save(userEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    
    return ResponseDto.success(HttpStatus.OK);
  }

  /**
   * description: 로그아웃 처리
   * 
   * <p>
   * <ul>
   * <li>토큰 검증</li>
   * <li>토큰 만료 시간 계산</li>
   * <li>블랙리스트에 토큰 추가</li>
   * </ul>
   * </p>
   *
   * @param dto {@link SignOutRequestDto} 로그아웃 요청 정보
   * @return 성공 시 {@link HttpStatus#OK} (200), 실패 시 오류 응답
   */
  @Override
  public ResponseEntity<ResponseDto> signOut(SignOutRequestDto dto) {
    try {
      // 현재 요청의 토큰 가져오기
      String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
          .getRequest().getHeader("Authorization");
      
      if (token == null || !token.startsWith("Bearer ")) {
        return ResponseDto.validationFail();
      }
      
      // "Bearer " 제거
      token = token.substring(7);
      
      // 토큰 검증
      String email = jwtProvider.validate(token);
      if (email == null) {
        return ResponseDto.validationFail();
      }
      
      // 토큰 만료 시간 계산
      long remainingTime = jwtProvider.getExpirationTime(token);
      if (remainingTime <= 0) {
        return ResponseDto.validationFail();
      }
      
      // 블랙리스트에 토큰 추가
      blacklistTokenRepository.addToBlacklist(token, remainingTime);
      
      return ResponseDto.success(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseDto.databaseError();
    }
  }
}