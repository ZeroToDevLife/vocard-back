package com.korit.vocard.common.vo;

import java.util.List;

import com.korit.vocard.common.entity.JpVocaExampleGroupEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaExampleGroupVO {
    private final Integer id;
    private final Integer exampleId;
    private final String exampleGroup;
    private final List<JpVocaExampleSubGroupVO> exampleSubGroups;

    @Builder
    private JpVocaExampleGroupVO(Integer id, Integer exampleId, String exampleGroup, List<JpVocaExampleSubGroupVO> exampleSubGroups) {
        this.id = id;
        this.exampleId = exampleId;
        this.exampleGroup = exampleGroup;
        this.exampleSubGroups = exampleSubGroups;
    }

    public static JpVocaExampleGroupVO from(JpVocaExampleGroupEntity entity) {
        return JpVocaExampleGroupVO.builder()
                .id(entity.getId())
                .exampleId(entity.getJpVocaExamples() != null ? entity.getJpVocaExamples().getId() : null)
                .exampleGroup(entity.getExampleGroup())
                .exampleSubGroups(entity.getExampleSubGroups() != null ? entity.getExampleSubGroups().stream().map(JpVocaExampleSubGroupVO::from).toList() : List.of())
                .build();
    }
} 