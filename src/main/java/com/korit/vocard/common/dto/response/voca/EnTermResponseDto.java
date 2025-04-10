package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.entity.TermDetailEnEntity;

import lombok.Getter;

@Getter
public class EnTermResponseDto {
    private final Integer id;
    private final Integer termsId;
    private final String word;
    private final String phonetic;
    private final String partOfSpeech;
    private final String meaning;
    private final String example;
    private final String exampleMeaning;

    public EnTermResponseDto(TermDetailEnEntity entity) {
        this.id = entity.getId();
        this.termsId = entity.getTerms().getId();
        this.word = entity.getWord();
        this.phonetic = entity.getPhonetic();
        this.partOfSpeech = entity.getPartOfSpeech();
        this.meaning = entity.getMeaning();
        this.example = entity.getExample();
        this.exampleMeaning = entity.getExampleMeaning();
    }
} 