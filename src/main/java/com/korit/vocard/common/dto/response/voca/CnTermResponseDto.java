package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.entity.TermDetailCnEntity;

import lombok.Getter;

@Getter
public class CnTermResponseDto {
    private final Integer id;
    private final Integer termsId;
    private final String word;
    private final String meaning;
    private final String phonetic;
    private final String example;
    private final String exampleMeaning;

    public CnTermResponseDto(TermDetailCnEntity entity) {
        this.id = entity.getId();
        this.termsId = entity.getTerms().getId();
        this.word = entity.getWord();
        this.meaning = entity.getMeaning();
        this.phonetic = entity.getPhonetic();
        this.example = entity.getExample();
        this.exampleMeaning = entity.getExampleMeaning();
    }
} 