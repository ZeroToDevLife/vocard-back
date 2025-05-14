package com.korit.vocard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korit.vocard.common.dto.response.voca.GetCnTermResponseDto;
import com.korit.vocard.common.dto.response.voca.GetEnTermResponseDto;
import com.korit.vocard.common.dto.response.voca.GetJpKanjiResponseDto;
import com.korit.vocard.common.dto.response.voca.GetJpVocaResponseDto;
import com.korit.vocard.service.TermsService;

import lombok.RequiredArgsConstructor;

/**
 * class: 일본어 단어 컨트롤러
 * 
 * description: 일본어 단어 관련 API를 처리합니다.
 */
@RestController
@RequestMapping("/api/v1/terms")
@RequiredArgsConstructor
public class TermsController {

    private final TermsService termsService;

    /**
     * description: 교재, 레벨, 일차에 해당하는 일본어 단어 목록을 조회합니다.
     * 
     * @param language 언어 코드 (예: "jp")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 단어 목록, 실패 시 오류 응답
     */
    @GetMapping("/voca/day/{dayNumber}")
    public ResponseEntity<? super GetJpVocaResponseDto> getJpVoca(
        @PathVariable(value = "dayNumber") int dayNumber,
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName,
        @RequestParam(value = "level") String level
    ) {
        return termsService.getJpVoca(language, bookName, level, dayNumber);
    }

    /**
     * description: 교재, 레벨, 일차에 해당하는 일본어 한자 목록을 조회합니다.
     * 
     * @param language 언어 코드 (예: "jp")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 단어 목록, 실패 시 오류 응답
     */
    @GetMapping("/kanji/day/{dayNumber}")
    public ResponseEntity<? super GetJpKanjiResponseDto> getJpKanji(
        @PathVariable(value = "dayNumber") int dayNumber,
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName,
        @RequestParam(value = "level") String level
    ) {
        return termsService.getJpKanji(language, bookName, level, dayNumber);
    }

    /**
     * description: 교재, 레벨, 일차에 해당하는 영어 단어 목록을 조회합니다.
     * 
     * @param language 언어 코드 (예: "en")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 단어 목록, 실패 시 오류 응답
     */
    @GetMapping("/en/day/{dayNumber}")
    public ResponseEntity<? super GetEnTermResponseDto> getEnTerm(
        @PathVariable(value = "dayNumber") int dayNumber,
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName,
        @RequestParam(value = "level") String level
    ) {
        return termsService.getEnTerm(language, bookName, level, dayNumber);
    }

    /**
     * description: 교재, 레벨, 일차에 해당하는 중국어 단어 목록을 조회합니다.
     * 
     * @param language 언어 코드 (예: "cn")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 단어 목록, 실패 시 오류 응답
     */
    @GetMapping("/cn/day/{dayNumber}")
    public ResponseEntity<? super GetCnTermResponseDto> getCnTerm(
        @PathVariable(value = "dayNumber") int dayNumber,
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName,
        @RequestParam(value = "level") String level
    ) {
        return termsService.getCnTerm(language, bookName, level, dayNumber);
    }
    
} 