package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.TermDetailEnEntity;

import lombok.Getter;

@Getter
public class GetEnTermResponseDto extends ResponseDto {
    private final List<EnTermResponseDto> terms;

    public GetEnTermResponseDto(List<TermDetailEnEntity> entities) {
        super(ResponseType.SUCCESS);
        this.terms = entities.stream()
                .map(EnTermResponseDto::new)
                .toList();
    }

    public static ResponseEntity<? super GetEnTermResponseDto> success(List<TermDetailEnEntity> termDetailEnEntities) {
        GetEnTermResponseDto body = new GetEnTermResponseDto(termDetailEnEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
} 