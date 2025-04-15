package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;
import com.korit.vocard.common.dto.response.voca.GetBookLevelsResponseDto;
import com.korit.vocard.common.dto.response.voca.GetLevelDaysResponseDto;

public interface BookMetadataService {
    ResponseEntity<? super GetBookLevelsResponseDto> getBookLevels(String language, String bookName);
    ResponseEntity<? super GetLevelDaysResponseDto> getLevelDays(String language, String bookName, String level);
} 