package com.korit.vocard.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.entity.TermBooksEntity;
import com.korit.vocard.common.entity.TermDaysEntity;
import com.korit.vocard.common.entity.TermLevelsEntity;
import com.korit.vocard.dto.GetBookLevelsResponseDto;
import com.korit.vocard.dto.GetLevelDaysResponseDto;
import com.korit.vocard.repository.TermBooksRepository;
import com.korit.vocard.repository.TermDaysRepository;
import com.korit.vocard.repository.TermLevelsRepository;
import com.korit.vocard.repository.TermsRepository;
import com.korit.vocard.service.BookMetadataService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookMetadataServiceImplement implements BookMetadataService {

    private final TermBooksRepository termBooksRepository;
    private final TermLevelsRepository termLevelsRepository;
    private final TermDaysRepository termDaysRepository;
    private final TermsRepository termsRepository;

    @Override
    public ResponseEntity<GetBookLevelsResponseDto> getBookLevels(String language, String bookName) {
        List<TermBooksEntity> books = termBooksRepository.findByLanguageAndName(language, bookName);
        if (books.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        TermBooksEntity book = books.get(0);
            
        List<TermLevelsEntity> levels = termLevelsRepository.findByTermBooksId(book.getId());
        
        return ResponseEntity.ok(GetBookLevelsResponseDto.builder()
            .bookId(book.getId().longValue())
            .bookName(book.getName())
            .levels(levels.stream()
                .map(level -> GetBookLevelsResponseDto.Level.builder()
                    .levelId(level.getId().longValue())
                    .level(level.getLevel())
                    .build())
                .collect(Collectors.toList()))
            .build());
    }

    @Override
    public ResponseEntity<GetLevelDaysResponseDto> getLevelDays(Integer levelId) {
        TermLevelsEntity level = termLevelsRepository.findById(levelId)
                .orElseThrow(() -> new RuntimeException("Level not found"));

        List<TermDaysEntity> days = termDaysRepository.findByTermLevelsId(levelId);

        return ResponseEntity.ok(GetLevelDaysResponseDto.builder()
                .levelId(levelId)
                .level(level.getLevel())
                .totalDays(days.size())
                .build());
    }

    @Override
    public ResponseEntity<GetLevelDaysResponseDto> getLevelDaysByBookAndLevel(String language, String bookName, String level) {
        System.out.println("Searching for book with language: " + language + ", bookName: " + bookName);
        List<TermBooksEntity> books = termBooksRepository.findByLanguageAndName(language, bookName);
        if (books.isEmpty()) {
            System.out.println("No books found for language: " + language + ", bookName: " + bookName);
            throw new RuntimeException("Book not found");
        }
        TermBooksEntity book = books.get(0);
        System.out.println("Found book with ID: " + book.getId());
        
        String levelStr = String.valueOf(level);
        System.out.println("Searching for level: " + levelStr + " in book with ID: " + book.getId());
        TermLevelsEntity termLevel = termLevelsRepository.findByTermBooksIdAndLevel(book.getId(), levelStr)
            .orElseThrow(() -> {
                System.out.println("Level not found for book ID: " + book.getId() + ", level: " + levelStr);
                return new RuntimeException("Level not found");
            });
        System.out.println("Found level with ID: " + termLevel.getId());
            
        List<TermDaysEntity> days = termLevel.getTermDays();
        int totalDays = days.stream()
            .mapToInt(TermDaysEntity::getDayNumber)
            .max()
            .orElse(0);
        System.out.println("Found max day number: " + totalDays + " for level ID: " + termLevel.getId());
        
        return ResponseEntity.ok(GetLevelDaysResponseDto.builder()
            .levelId(termLevel.getId())
            .level(termLevel.getLevel())
            .totalDays(totalDays)
            .build());
    }
} 