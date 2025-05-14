package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.utils.GetRandomNicknameResponseDto;

/**
 * interface: 닉네임 생성 서비스
 * 
 * description: 랜덤 닉네임 생성 기능을 제공합니다.
 */
public interface NicknameCreateService {
    
    /**
     * description: 랜덤 닉네임을 생성합니다.
     * 
     * @return 생성된 랜덤 닉네임 (영문자로 시작하고 영문자+숫자로 구성된 3~20자)
     */
    ResponseEntity<? super GetRandomNicknameResponseDto> generateRandomNickname();
} 