package com.korit.vocard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korit.vocard.dto.GetBookLevelsResponseDto;
import com.korit.vocard.dto.GetLevelDaysResponseDto;
import com.korit.vocard.service.BookMetadataService;

import lombok.RequiredArgsConstructor;

/**
 * class: 단어장 메타데이터 컨트롤러
 * 
 * description: 단어장의 레벨 개수와 레벨별 일차 개수를 조회하는 API를 제공합니다.
 */
@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookMetadataController {

    private final BookMetadataService bookMetadataService;

    /**
     * description: 단어장의 레벨 목록을 조회합니다.
     * 
     * <p>
     * <ul>
     * <li>언어와 단어장 이름으로 레벨 목록 조회</li>
     * <li>레벨 ID와 레벨 번호 반환</li>
     * </ul>
     * </p>
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 단어장 이름
     * @return 성공 시 {@link GetBookLevelsResponseDto}, 실패 시 오류 응답
     */
    @GetMapping("/levels")
    public ResponseEntity<GetBookLevelsResponseDto> getBookLevels(
        @RequestParam String language,
        @RequestParam String bookName
    ) {
        return bookMetadataService.getBookLevels(language, bookName);
    }

    /**
     * description: 단어장의 레벨에 해당하는 일차 목록을 조회합니다.
     * 
     * <p>
     * <ul>
     * <li>레벨 ID로 일차 목록 조회</li>
     * <li>일차 ID와 일차 번호 반환</li>
     * </ul>
     * </p>
     *
     * @param levelId 레벨 ID
     * @return 성공 시 {@link GetLevelDaysResponseDto}, 실패 시 오류 응답
     */
    @GetMapping("/levels/{levelId}/days")
    public ResponseEntity<GetLevelDaysResponseDto> getLevelDays(@PathVariable Integer levelId) {
        return bookMetadataService.getLevelDays(levelId);
    }

    /**
     * description: 단어장의 레벨에 해당하는 일차 목록을 조회합니다.
     * 
     * <p>
     * <ul>
     * <li>언어, 단어장 이름, 레벨로 일차 목록 조회</li>
     * <li>일차 ID와 일차 번호 반환</li>
     * </ul>
     * </p>
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 단어장 이름
     * @param level 레벨 (예: "N1")
     * @return 성공 시 {@link GetLevelDaysResponseDto}, 실패 시 오류 응답
     */
    @GetMapping("/days")
    public ResponseEntity<GetLevelDaysResponseDto> getLevelDaysByBookAndLevel(
        @RequestParam String language,
        @RequestParam String bookName,
        @RequestParam String level
    ) {
        return bookMetadataService.getLevelDaysByBookAndLevel(language, bookName, level);
    }
} 