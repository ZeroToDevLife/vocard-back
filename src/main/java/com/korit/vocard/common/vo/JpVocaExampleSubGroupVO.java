package com.korit.vocard.common.vo;

import java.util.List;

import com.korit.vocard.common.entity.JpVocaExampleSubGroupEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaExampleSubGroupVO {
    private final Integer id;
    private final String exampleSubGroup;
    private final String relatedType;
    private final String related;
    private final List<JpVocaExampleGroupDetailVO> details;

    @Builder
    private JpVocaExampleSubGroupVO(Integer id, String exampleSubGroup, String relatedType, String related, List<JpVocaExampleGroupDetailVO> details) {
        this.id = id;
        this.exampleSubGroup = exampleSubGroup;
        this.relatedType = relatedType;
        this.related = related;
        this.details = details;
    }

    public static JpVocaExampleSubGroupVO from(JpVocaExampleSubGroupEntity entity) {
        return JpVocaExampleSubGroupVO.builder()
                .id(entity.getId())
                .exampleSubGroup(entity.getExampleSubGroup())
                .relatedType(entity.getRelatedType())
                .related(entity.getRelated())
                .details(entity.getDetails() != null ? entity.getDetails().stream().map(JpVocaExampleGroupDetailVO::from).toList() : List.of())
                .build();
    }
} 