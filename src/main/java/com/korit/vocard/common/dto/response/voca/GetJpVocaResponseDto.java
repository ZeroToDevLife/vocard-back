package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.vo.JpVocaTermVO;

import lombok.Getter;

@Getter
public class GetJpVocaResponseDto extends ResponseDto {
    private final List<JpVocaTermResponseDto> terms;

    public GetJpVocaResponseDto(List<JpVocaTermVO> terms) {
        super(ResponseType.SUCCESS);
        this.terms = terms.stream()
                .map(JpVocaTermResponseDto::new)
                .toList();
    }
} 