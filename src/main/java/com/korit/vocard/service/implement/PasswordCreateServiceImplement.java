package com.korit.vocard.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.response.utils.GetTemporaryPasswordResponseDto;
import com.korit.vocard.common.util.RandomUtils;
import com.korit.vocard.service.PasswordCreateService;

/**
 * class: 비밀번호 생성 서비스 구현체
 * 
 * description: 임시 비밀번호 생성 기능을 구현합니다.
 */
@Service
public class PasswordCreateServiceImplement implements PasswordCreateService {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!?";

    /**
     * description: 랜덤 임시 비밀번호 생성
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
     * @return 생성된 랜덤 비밀번호
     */
    @Override
    public ResponseEntity<? super GetTemporaryPasswordResponseDto> generateTemporaryPassword() {
        String temporaryPassword = RandomUtils.generateTemporaryPassword();
        return GetTemporaryPasswordResponseDto.success(temporaryPassword);
    }
} 