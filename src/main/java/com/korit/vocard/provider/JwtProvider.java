package com.korit.vocard.provider;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * class: JWT 토큰 생성 및 검증을 담당하는 제공자 클래스입니다.
 * 
 * description: JWT 토큰의 생성과 검증을 담당하는 클래스입니다.
 * 
 * <p>
 * <ul>
 * <li>서명 알고리즘: {@code HS256}</li>
 * <li>비밀 키: application.properties 또는 환경변수의 {@code jwt.secret}</li>
 * <li>토큰 유효기간: 9시간</li>
 * </ul>
 * </p>
 */
@Component
public class JwtProvider {
  /**
   * description: JWT 서명에 사용되는 비밀 키
   */
  @Value("${jwt.secret}")
  private String secretKey;

  /**
   * description: JWT 생성 메서드
   *
   * <p>
   * <ul>
   * <li>{@code sub} (Subject): 사용자의 이메일</li>
   * <li>{@code iat} (Issued At): 토큰 생성 시간</li>
   * <li>{@code exp} (Expiration): 생성 시간 기준 9시간 후</li>
   * </ul>
   * </p>
   *
   * @param email 토큰에 포함할 사용자 이메일
   * @return 생성된 JWT 문자열, 실패 시 {@code null}
   */
  public String create(String email) {

    Date expiration = Date.from(Instant.now().plus(9, ChronoUnit.HOURS));

    SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    String jwt = null;

    try {

      jwt = Jwts.builder()
        .signWith(key, Jwts.SIG.HS256)
        .subject(email)
        .issuedAt(new Date())
        .expiration(expiration)
        .compact();

    } catch (Exception exception) {
      exception.printStackTrace();
    }

    return jwt;

  }

  /**
   * description: JWT 검증 메서드
   * 
   * <p>
   * <ul>
   * <li>토큰 서명 검증</li>
   * <li>토큰 만료 여부 확인</li>
   * <li>토큰에서 사용자 이메일(subject) 추출</li>
   * </ul>
   * </p>
   * 
   * @param jwt 클라이언트로부터 받은 JWT 문자열
   * @return 유효한 토큰이면 이메일, 아니면 {@code null}
   */
  public String validate(String jwt) {

    String email = null;

    SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    try {

      email = Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(jwt)
        .getPayload()
        .getSubject();

    } catch(Exception exception) {
      exception.printStackTrace();
    }

    return email;

  }

  /**
   * description: 토큰의 만료까지 남은 시간을 초 단위로 반환
   *
   * @param token JWT 토큰
   * @return 만료까지 남은 시간(초), 만료되었거나 유효하지 않은 토큰이면 0
   */
  public long getExpirationTime(String token) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
      
      Claims claims = Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();
      
      Date expiration = claims.getExpiration();
      Date now = new Date();
      
      return Math.max(0, (expiration.getTime() - now.getTime()) / 1000);
    } catch (Exception e) {
      return 0;
    }
  }

}