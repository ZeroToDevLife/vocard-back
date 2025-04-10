package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.entity.TermDetailJpKanjiEntity;

import lombok.Getter;

@Getter
public class JpKanjiTermResponseDto {
    private final Integer id;
    private final Integer termsId;
    private final String word;
    private final String meaning;
    private final String shape;
    private final String radical;
    private final String strokes;
    private final String onReading;
    private final String kunReading;

    public JpKanjiTermResponseDto(TermDetailJpKanjiEntity entity) {
        this.id = entity.getId();
        this.termsId = entity.getTerms().getId();
        this.word = entity.getWord();
        this.meaning = entity.getMeaning();
        this.shape = entity.getShape();
        this.radical = entity.getRadical();
        this.strokes = entity.getStrokes();
        this.onReading = entity.getOnReading();
        this.kunReading = entity.getKunReading();
    }
} 