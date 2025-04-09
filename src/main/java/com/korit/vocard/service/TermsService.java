package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.voca.GetJpVocaResponseDto;

/**
 * interface: 일본어 단어 서비스 인터페이스
 * 
 * description: 일본어 단어 조회 기능을 정의합니다.
 */
public interface TermsService {

    /**
     * description: 교재, 레벨, 일차에 해당하는 일본어 단어 목록을 조회합니다.
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 {@link GetJpVocaResponseDto}, 실패 시 오류 응답
     */
    ResponseEntity<? super GetJpVocaResponseDto> getJpVoca(String language, String bookName, String level, int dayNumber);
} 