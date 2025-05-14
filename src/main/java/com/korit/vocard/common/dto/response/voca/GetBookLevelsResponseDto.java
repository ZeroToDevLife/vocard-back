package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.TermLevelsEntity;

import lombok.Getter;

@Getter
public class GetBookLevelsResponseDto extends ResponseDto {
    private final List<BookLevelResponseDto> levels;

    public GetBookLevelsResponseDto(List<TermLevelsEntity> entities) {
        super(ResponseType.SUCCESS);
        this.levels = entities.stream()
                .map(BookLevelResponseDto::new)
                .toList();
    }

    public static ResponseEntity<? super GetBookLevelsResponseDto> success(List<TermLevelsEntity> termLevelsEntities) {
        GetBookLevelsResponseDto body = new GetBookLevelsResponseDto(termLevelsEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
} 