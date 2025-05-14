package com.korit.vocard.common.dto.response;

/**
 * enum: 응답 타입 열거형
 * 
 * description: 각 항목은 고유한 응답 코드({@code code})와 그에 해당하는 메시지({@code message})를 가지고 있으며,
 * 클라이언트에게 일관된 형식으로 응답을 제공하기 위해 사용됩니다.
 *
 * <p><b>예시:</b> {@code ResponseType.SUCCESS.getCode()} → {@code "SU"}, {@code ResponseType.SUCCESS.getMessage()} → {@code "Success."}</p>
 */
public enum ResponseType {

  /** 
   * description: 요청 성공
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "SU"}</li>
   * <li>메시지: {@code "Success."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#OK}</li>
   * </ul>
   * </p>
   */
  SUCCESS("SU", "Success."),

  /** 
   * description: 유효성 검사 실패
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "VF"}</li>
   * <li>메시지: {@code "Validation fail."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#BAD_REQUEST}</li>
   * </ul>
   * </p>
   */ 
  VALIDATION_FAIL("VF", "Validation fail."),

  /**
   * description: 이메일 인증 코드 불일치
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "EVF"}</li>
   * <li>메시지: {@code "Email Verification Fail."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#BAD_REQUEST}</li>
   * </ul>
   * </p>
   */
  EMAIL_VERIFICATION_FAIL("EVF", "Email Verification Fail."),

  /**
   * description: 존재하는 이메일
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "EE"}</li>
   * <li>메시지: {@code "Exist email."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#BAD_REQUEST}</li>
   * </ul>
   * </p>
   */
  EXIST_EMAIL("EE", "Exist email."),

  /** 
   * description: 로그인 실패
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "SF"}</li>
   * <li>메시지: {@code "Sign In Fail."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#UNAUTHORIZED}</li>
   * </ul>
   * </p>
   */ 
  SIGN_IN_FAIL("SF", "Sign In Fail."),

    /** 
   * description: 존재하지 않는 유저
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "UE"}</li>
   * <li>메시지: {@code "User Not Exist."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#UNAUTHORIZED}</li>
   * </ul>
   * </p>
   */ 
  USER_NOT_EXIST("UE", "User Not Exist."),

    /** 
   * description: 이메일 전송 오류
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "ESE"}</li>
   * <li>메시지: {@code "Email Send Error."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#INTERNAL_SERVER_ERROR}</li>
   * </ul>
   * </p>
   */ 
  EMAIL_SEND_ERROR("ESE", "Email Send Error."),

  /** 
   * description: 데이터베이스 오류
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "DBE"}</li>
   * <li>메시지: {@code "Database Error."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#INTERNAL_SERVER_ERROR}</li>
   * </ul>
   * </p>
   */ 
  DATABASE_ERROR("DBE", "Database Error."),

  /** 
   * description: 리소스를 찾을 수 없음
   * 
   * <p>
   * <ul>
   * <li>코드: {@code "NF"}</li>
   * <li>메시지: {@code "Not Found."}</li>
   * <li>HTTP 상태: {@link org.springframework.http.HttpStatus#NOT_FOUND}</li>
   * </ul>
   * </p>
   */ 
  NOT_FOUND("NF", "Not Found.");

  /** 
   * description: API 응답의 상태를 나타내는 코드값
   */
  private final String code;

  /** 
   * description: API 응답의 상세 메시지
   */
  private final String message;

  /**
   * description: 응답 타입 생성자입니다.
   *
   * @param code 응답 코드
   * @param message 응답 메시지
   */
  ResponseType(String code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * description: 응답 코드를 반환합니다.
   *
   * @return 응답 코드 (예: "SU", "VF" 등)
   */
  public String getCode() {
    return code;
  }

  /**
   * description: 응답 메시지를 반환합니다.
   *
   * @return 응답 메시지 (예: "Success.", "Validation fail." 등)
   */
  public String getMessage() {
    return message;
  }
}