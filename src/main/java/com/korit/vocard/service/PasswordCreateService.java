package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.utils.GetTemporaryPasswordResponseDto;

/**
 * interface: 비밀번호 생성 서비스
 * 
 * description: 임시 비밀번호 생성 관련 기능을 정의합니다.
 */
public interface PasswordCreateService {
    
    /**
     * description: 랜덤 임시 비밀번호를 생성합니다.
     * 
     * <p>
     * 다음 요구사항을 충족하는 비밀번호 생성:
     * <ul>
     * <li>영문 대문자, 소문자, 숫자, 특수문자(!?) 각 1개 이상 포함</li>
     * <li>총 8자리의 랜덤 비밀번호</li>
     * <li>보안을 위해 문자열 섞기</li>
     * </ul>
     * </p>
     *
     * @return 생성된 임시 비밀번호가 포함된 응답
     */
    ResponseEntity<? super GetTemporaryPasswordResponseDto> generateTemporaryPassword();
} 