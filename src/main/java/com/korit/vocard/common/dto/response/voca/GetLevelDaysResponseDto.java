package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.TermDaysEntity;

import lombok.Getter;

@Getter
public class GetLevelDaysResponseDto extends ResponseDto {
    private final List<LevelDayResponseDto> days;

    public GetLevelDaysResponseDto(List<TermDaysEntity> entities) {
        super(ResponseType.SUCCESS);
        this.days = entities.stream()
                .map(LevelDayResponseDto::new)
                .toList();
    }

    public static ResponseEntity<? super GetLevelDaysResponseDto> success(List<TermDaysEntity> termDaysEntities) {
        GetLevelDaysResponseDto body = new GetLevelDaysResponseDto(termDaysEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
} 