package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.dto.GetBookLevelsResponseDto;
import com.korit.vocard.dto.GetLevelDaysResponseDto;

/**
 * interface: 단어장 메타데이터 서비스 인터페이스
 * 
 * description: 단어장의 레벨 개수와 레벨별 일차 개수를 조회하는 기능을 정의합니다.
 */
public interface BookMetadataService {

    /**
     * description: 단어장의 레벨 목록을 조회합니다.
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 단어장 이름
     * @return 성공 시 {@link GetBookLevelsResponseDto}, 실패 시 오류 응답
     */
    ResponseEntity<GetBookLevelsResponseDto> getBookLevels(String language, String bookName);

    /**
     * description: 단어장의 레벨에 해당하는 일차 목록을 조회합니다.
     *
     * @param levelId 레벨 ID
     * @return 성공 시 {@link GetLevelDaysResponseDto}, 실패 시 오류 응답
     */
    ResponseEntity<GetLevelDaysResponseDto> getLevelDays(Integer levelId);

    /**
     * description: 단어장의 레벨에 해당하는 일차 목록을 조회합니다.
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 단어장 이름
     * @param level 레벨 (예: "N1")
     * @return 성공 시 {@link GetLevelDaysResponseDto}, 실패 시 오류 응답
     */
    ResponseEntity<GetLevelDaysResponseDto> getLevelDaysByBookAndLevel(String language, String bookName, String level);
} 