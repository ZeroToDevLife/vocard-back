package com.korit.vocard.common.vo;

import java.util.List;

import com.korit.vocard.common.entity.JpVocaExamples;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaExampleVO {
    private final Integer id;
    private final Integer termDetailId;
    private final String partSpeech;
    private final List<JpVocaExampleGroupVO> groups;

    @Builder
    private JpVocaExampleVO(Integer id, Integer termDetailId, String partSpeech, List<JpVocaExampleGroupVO> groups) {
        this.id = id;
        this.termDetailId = termDetailId;
        this.partSpeech = partSpeech;
        this.groups = groups;
    }

    public static JpVocaExampleVO from(JpVocaExamples entity) {
        return JpVocaExampleVO.builder()
                .id(entity.getId())
                .termDetailId(entity.getTermDetailJpVoca().getId())
                .partSpeech(entity.getPartSpeech())
                .groups(entity.getJpVocaExampleGroup().stream()
                        .map(JpVocaExampleGroupVO::from)
                        .toList())
                .build();
    }
} 