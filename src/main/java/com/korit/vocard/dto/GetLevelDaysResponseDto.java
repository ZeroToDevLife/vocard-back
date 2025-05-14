package com.korit.vocard.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetLevelDaysResponseDto {
    private Integer levelId;
    private String level;
    private int totalDays;
} 