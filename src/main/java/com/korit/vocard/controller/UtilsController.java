package com.korit.vocard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.vocard.common.dto.response.utils.GetRandomNicknameResponseDto;
import com.korit.vocard.service.NicknameCreateService;

import lombok.RequiredArgsConstructor;

/**
 * class: 유틸리티 API 컨트롤러
 * 
 * description: 인증이 필요 없는 유틸리티성 API를 제공합니다.
 * 
 * <p>기본 경로: {@code /api/v1/utils}</p>
 */
@RestController
@RequestMapping("/api/v1/utils")
@RequiredArgsConstructor
public class UtilsController {
    
    /**
     * description: 닉네임 생성 서비스 
     */
    private final NicknameCreateService nicknameService;
    
    /**
     * description: 랜덤 닉네임을 생성합니다.
     * 
     * @return 닉네임 문자열이 포함된 성공 응답
     */
    @GetMapping("/random-nickname")
    public ResponseEntity<? super GetRandomNicknameResponseDto> getRandomNickname() {
        ResponseEntity<? super GetRandomNicknameResponseDto> response = nicknameService.generateRandomNickname();
        return response;
    }
} 