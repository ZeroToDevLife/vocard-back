package com.korit.vocard.service.implement;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.response.voca.GetBookLevelsResponseDto;
import com.korit.vocard.common.dto.response.voca.GetLevelDaysResponseDto;
import com.korit.vocard.repository.TermBooksRepository;
import com.korit.vocard.service.BookMetadataService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookMetadataServiceImplement implements BookMetadataService {

    private final TermBooksRepository termBooksRepository;

    @Override
    public ResponseEntity<? super GetBookLevelsResponseDto> getBookLevels(String language, String bookName) {
        try {
            // 교재가 존재하는지 먼저 확인
            if (termBooksRepository.findByLanguageAndName(language, bookName) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            // 레벨 목록 조회
            List<String> levels = termBooksRepository.findLevelsByLanguageAndBookName(language, bookName);
            if (levels == null || levels.isEmpty()) {
                levels = Collections.emptyList();
            } else {
                Collections.sort(levels);
            }

            return ResponseEntity.status(HttpStatus.OK).body(new GetBookLevelsResponseDto(levels));
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<? super GetLevelDaysResponseDto> getLevelDays(String language, String bookName, String level) {
        try {
            // 일차 수 카운트
            Integer totalDays = termBooksRepository.countDaysByLanguageAndBookNameAndLevel(
                language, bookName, level);
            
            if (totalDays == null) {
                totalDays = 0;
            }
            
            return ResponseEntity.status(HttpStatus.OK).body(new GetLevelDaysResponseDto(totalDays));
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
} 