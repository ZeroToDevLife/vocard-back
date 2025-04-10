package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.TermDetailCnEntity;

import lombok.Getter;

@Getter
public class GetCnTermResponseDto extends ResponseDto {
    private final List<CnTermResponseDto> terms;

    public GetCnTermResponseDto(List<TermDetailCnEntity> entities) {
        super(ResponseType.SUCCESS);
        this.terms = entities.stream()
                .map(CnTermResponseDto::new)
                .toList();
    }

    public static ResponseEntity<? super GetCnTermResponseDto> success(List<TermDetailCnEntity> termDetailCnEntities) {
        GetCnTermResponseDto body = new GetCnTermResponseDto(termDetailCnEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
} 