package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.entity.TermDaysEntity;

import lombok.Getter;

@Getter
public class LevelDayResponseDto {
    private final Integer id;
    private final Integer dayNumber;

    public LevelDayResponseDto(TermDaysEntity entity) {
        this.id = entity.getId();
        this.dayNumber = entity.getDayNumber();
    }
} 