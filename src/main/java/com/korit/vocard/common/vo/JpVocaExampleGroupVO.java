package com.korit.vocard.common.vo;

import java.util.List;

import com.korit.vocard.common.entity.JpVocaExampleGroup;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaExampleGroupVO {
    private final Integer id;
    private final Integer exampleId;
    private final String exampleGroup;
    private final String relatedType;
    private final String related;
    private final List<JpVocaExampleGroupDetailVO> details;

    @Builder
    private JpVocaExampleGroupVO(Integer id, Integer exampleId, String exampleGroup, 
            String relatedType, String related, List<JpVocaExampleGroupDetailVO> details) {
        this.id = id;
        this.exampleId = exampleId;
        this.exampleGroup = exampleGroup;
        this.relatedType = relatedType;
        this.related = related;
        this.details = details;
    }

    public static JpVocaExampleGroupVO from(JpVocaExampleGroup entity) {
        return JpVocaExampleGroupVO.builder()
                .id(entity.getId())
                .exampleId(entity.getJpVocaExamples().getId())
                .exampleGroup(entity.getExampleGroup())
                .relatedType(entity.getRelatedType())
                .related(entity.getRelated())
                .details(entity.getJpVocaExampleGroupDetail().stream()
                        .map(JpVocaExampleGroupDetailVO::from)
                        .toList())
                .build();
    }
} 