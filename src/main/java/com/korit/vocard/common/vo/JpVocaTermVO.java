package com.korit.vocard.common.vo;

import java.util.List;

import com.korit.vocard.common.entity.TermDetailJpVocaEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaTermVO {
    private final Integer id;
    private final Integer termsId;
    private final String word;
    private final String yomigana;
    private final String meaning;
    private final List<JpVocaExampleVO> examples;

    @Builder
    private JpVocaTermVO(Integer id, Integer termsId, String word, String meaning, String yomigana, List<JpVocaExampleVO> examples) {
        this.id = id;
        this.termsId = termsId;
        this.word = word;
        this.meaning = meaning;
        this.yomigana = yomigana;
        this.examples = examples;
    }

    public static JpVocaTermVO from(TermDetailJpVocaEntity entity) {
        return JpVocaTermVO.builder()
                .id(entity.getId())
                .termsId(entity.getTerms().getId())
                .word(entity.getWord())
                .meaning(entity.getMeaning())
                .yomigana(entity.getYomigana())
                .examples(entity.getJpVocaExamples().stream()
                        .map(JpVocaExampleVO::from)
                        .toList())
                .build();
    }
} 