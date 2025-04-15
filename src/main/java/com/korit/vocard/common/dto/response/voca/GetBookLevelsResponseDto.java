package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class GetBookLevelsResponseDto extends ResponseDto {
    private final List<String> levels;
    private final int totalLevels;

    public GetBookLevelsResponseDto(List<String> levels) {
        super(ResponseType.SUCCESS);
        this.levels = levels;
        this.totalLevels = levels.size();
    }
} 