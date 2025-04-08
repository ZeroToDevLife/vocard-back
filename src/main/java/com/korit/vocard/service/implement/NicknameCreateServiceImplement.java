package com.korit.vocard.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.response.utils.GetRandomNicknameResponseDto;
import com.korit.vocard.common.util.RandomUtils;
import com.korit.vocard.service.NicknameCreateService;

/**
 * class: 닉네임 생성 서비스 구현체
 * 
 * description: 랜덤 닉네임 생성 기능을 구현합니다.
 */
@Service
public class NicknameCreateServiceImplement implements NicknameCreateService {

    /**
     * description: 랜덤 닉네임을 생성합니다.
     * 
     * @return 생성된 랜덤 닉네임이 포함된 응답
     */
    @Override
    public ResponseEntity<? super GetRandomNicknameResponseDto> generateRandomNickname() {
        String nickname = RandomUtils.generateNickname();
        return GetRandomNicknameResponseDto.success(nickname);
    }
} 