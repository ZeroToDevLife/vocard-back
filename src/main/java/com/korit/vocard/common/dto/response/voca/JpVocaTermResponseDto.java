package com.korit.vocard.common.dto.response.voca;

import java.util.List;

import com.korit.vocard.common.vo.JpVocaTermVO;

import lombok.Getter;

@Getter
public class JpVocaTermResponseDto {
    private final Integer id;
    private final Integer termsId;
    private final String word;
    private final String yomigana;
    private final String meaning;
    private final List<JpVocaExampleResponseDto> examples;

    public JpVocaTermResponseDto(JpVocaTermVO vo) {
        this.id = vo.getId();
        this.termsId = vo.getTermsId();
        this.word = vo.getWord();
        this.yomigana = vo.getYomigana();
        this.meaning = vo.getMeaning();
        this.examples = vo.getExamples().stream()
                .map(JpVocaExampleResponseDto::new)
                .toList();
    }
} 