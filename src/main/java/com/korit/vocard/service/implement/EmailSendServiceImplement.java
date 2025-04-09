package com.korit.vocard.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.utils.SendTemporaryPasswordEmailResponseDto;
import com.korit.vocard.common.dto.response.utils.SendVerificationEmailResponseDto;
import com.korit.vocard.service.EmailSendService;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

/**
 * class: 이메일 발송 서비스 구현체
 * 
 * description: 다양한 유형의 이메일 발송 기능을 구현합니다.
 */
@Service
@RequiredArgsConstructor
public class EmailSendServiceImplement implements EmailSendService {

  private final JavaMailSender javaMailSender;
  
  /**
   * description: 인증 코드 이메일 발송
   *
   * @param email 수신자 이메일
   * @param code 인증 코드
   * @return 이메일 발송 성공 시 {@code true}, 실패 시 {@code false}
   */
  @Override
  public ResponseEntity<? super SendVerificationEmailResponseDto> sendVerificationEmail(String email, Integer code) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
    
      helper.setTo(email);
      helper.setSubject("[Vocard] 이메일 인증 코드입니다.");
      helper.setText("""
          <div style="font-family: sans-serif; padding: 10px;">
            <h2>안녕하세요! Vocard 인증 안내입니다.</h2>
            <p>아래 코드를 인증 페이지에 입력해주세요:</p>
            <h3 style="color: blue;">인증 코드: <strong>"""
             + code + """
             </strong></h3>
          </div>
          """
          , true); // true → HTML 사용
      
      javaMailSender.send(message);
      return SendVerificationEmailResponseDto.success();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.emailSendError();
    }
  }
  
  /**
   * description: 임시 비밀번호 이메일 발송
   *
   * @param email 수신자 이메일
   * @param temporaryPassword 임시 비밀번호
   * @return 이메일 발송 성공 시 {@code true}, 실패 시 {@code false}
   */
  @Override
  public ResponseEntity<? super SendTemporaryPasswordEmailResponseDto> sendTemporaryPasswordEmail(String email, String temporaryPassword) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
      
      helper.setTo(email);
      helper.setSubject("[Vocard] 임시 비밀번호가 발급되었습니다.");
      helper.setText("""
          <div style="font-family: sans-serif; padding: 10px;">
            <h2>안녕하세요! Vocard 임시 비밀번호 안내입니다.</h2>
            <p>요청하신 임시 비밀번호입니다. 로그인 후 보안을 위해 비밀번호를 변경해주세요.</p>
            <h3 style="color: blue;">임시 비밀번호: <strong>"""
            + temporaryPassword + """
            </strong></h3>
          </div>
          """
          , true); // true → HTML 사용
      
      javaMailSender.send(message);
      return SendTemporaryPasswordEmailResponseDto.success();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.emailSendError();
    }
  }
} 