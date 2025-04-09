package com.korit.vocard.common.dto.response.voca;

import com.korit.vocard.common.vo.JpVocaExampleGroupDetailVO;

import lombok.Getter;

@Getter
public class JpVocaExampleGroupDetailResponseDto {
    private final Integer id;
    private final Integer groupId;
    private final String groupDetailExample;
    private final String groupDetailMeaning;

    public JpVocaExampleGroupDetailResponseDto(JpVocaExampleGroupDetailVO vo) {
        this.id = vo.getId();
        this.groupId = vo.getGroupId();
        this.groupDetailExample = vo.getGroupDetailExample();
        this.groupDetailMeaning = vo.getGroupDetailMeaning();
    }
} 