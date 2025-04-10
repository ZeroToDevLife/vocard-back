package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.TermDetailJpKanjiEntity;

import lombok.Getter;

@Getter
public class GetJpKanjiResponseDto extends ResponseDto {
    private final List<JpKanjiTermResponseDto> terms;

    public GetJpKanjiResponseDto(List<TermDetailJpKanjiEntity> entities) {
        super(ResponseType.SUCCESS);
        this.terms = entities.stream()
                .map(JpKanjiTermResponseDto::new)
                .toList();
    }

    public static ResponseEntity<? super GetJpKanjiResponseDto> success(List<TermDetailJpKanjiEntity> termDetailJpKanjiEntities) {
        GetJpKanjiResponseDto body = new GetJpKanjiResponseDto(termDetailJpKanjiEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
} 