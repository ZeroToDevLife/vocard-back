package com.korit.vocard.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetBookLevelsResponseDto {
    private Long bookId;
    private String bookName;
    private List<Level> levels;

    @Getter
    @Builder
    public static class Level {
        private Long levelId;
        private String level;
    }
} 