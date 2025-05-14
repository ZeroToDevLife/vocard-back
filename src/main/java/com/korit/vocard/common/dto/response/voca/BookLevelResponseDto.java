package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.entity.TermLevelsEntity;

import lombok.Getter;

@Getter
public class BookLevelResponseDto {
    private final Integer id;
    private final String level;

    public BookLevelResponseDto(TermLevelsEntity entity) {
        this.id = entity.getId();
        this.level = entity.getLevel();
    }
} 