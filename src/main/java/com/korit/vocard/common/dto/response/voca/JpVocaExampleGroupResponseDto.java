package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.vo.JpVocaExampleGroupVO;

import lombok.Getter;

@Getter
public class JpVocaExampleGroupResponseDto {
    private final Integer id;
    private final Integer exampleId;
    private final String exampleGroup;
    private final List<JpVocaExampleSubGroupResponseDto> exampleSubGroups;

    public JpVocaExampleGroupResponseDto(JpVocaExampleGroupVO vo) {
        this.id = vo.getId();
        this.exampleId = vo.getExampleId();
        this.exampleGroup = vo.getExampleGroup();
        this.exampleSubGroups = vo.getExampleSubGroups().stream().map(JpVocaExampleSubGroupResponseDto::new).toList();
    }
} 