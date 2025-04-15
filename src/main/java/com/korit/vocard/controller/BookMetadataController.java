package com.korit.vocard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korit.vocard.common.dto.response.voca.GetBookLevelsResponseDto;
import com.korit.vocard.common.dto.response.voca.GetLevelDaysResponseDto;
import com.korit.vocard.service.BookMetadataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookMetadataController {

    private final BookMetadataService bookMetadataService;

    @GetMapping("/levels")
    public ResponseEntity<? super GetBookLevelsResponseDto> getBookLevels(
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName
    ) {
        return bookMetadataService.getBookLevels(language, bookName);
    }

    @GetMapping("/days")
    public ResponseEntity<? super GetLevelDaysResponseDto> getLevelDays(
        @RequestParam(value = "language") String language,
        @RequestParam(value = "bookName") String bookName,
        @RequestParam(value = "level") String level
    ) {
        return bookMetadataService.getLevelDays(language, bookName, level);
    }
} 