package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.vo.JpVocaExampleVO;

import lombok.Getter;

@Getter
public class JpVocaExampleResponseDto {
    private final Integer id;
    private final Integer termDetailId;
    private final String partSpeech;
    private final List<JpVocaExampleGroupResponseDto> groups;

    public JpVocaExampleResponseDto(JpVocaExampleVO vo) {
        this.id = vo.getId();
        this.termDetailId = vo.getTermDetailId();
        this.partSpeech = vo.getPartSpeech();
        this.groups = vo.getGroups().stream()
                .map(JpVocaExampleGroupResponseDto::new)
                .toList();
    }
} 