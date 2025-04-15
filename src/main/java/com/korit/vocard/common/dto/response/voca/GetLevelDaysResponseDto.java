package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class GetLevelDaysResponseDto extends ResponseDto {
    private final int totalDays;

    public GetLevelDaysResponseDto(int totalDays) {
        super(ResponseType.SUCCESS);
        this.totalDays = totalDays;
    }
} 