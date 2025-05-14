package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.vo.JpVocaExampleSubGroupVO;

import lombok.Getter;

@Getter
public class JpVocaExampleSubGroupResponseDto {
    private final Integer id;
    private final String exampleSubGroup;
    private final String relatedType;
    private final String related;
    private final List<JpVocaExampleGroupDetailResponseDto> details;

    public JpVocaExampleSubGroupResponseDto(JpVocaExampleSubGroupVO vo) {
        this.id = vo.getId();
        this.exampleSubGroup = vo.getExampleSubGroup();
        this.relatedType = vo.getRelatedType();
        this.related = vo.getRelated();
        this.details = vo.getDetails().stream().map(JpVocaExampleGroupDetailResponseDto::new).toList();
    }
} 