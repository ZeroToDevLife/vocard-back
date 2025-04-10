package com.korit.vocard.common.vo;

import com.korit.vocard.common.entity.JpVocaExampleGroupDetailEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JpVocaExampleGroupDetailVO {
    private final Integer id;
    private final Integer groupId;
    private final String groupDetailExample;
    private final String groupDetailMeaning;

    @Builder
    private JpVocaExampleGroupDetailVO(Integer id, Integer groupId, String groupDetailExample, String groupDetailMeaning) {
        this.id = id;
        this.groupId = groupId;
        this.groupDetailExample = groupDetailExample;
        this.groupDetailMeaning = groupDetailMeaning;
    }

    public static JpVocaExampleGroupDetailVO from(JpVocaExampleGroupDetailEntity entity) {
        return JpVocaExampleGroupDetailVO.builder()
                .id(entity.getId())
                .groupId(entity.getJpVocaExampleGroup().getId())
                .groupDetailExample(entity.getGroupDetailExample())
                .groupDetailMeaning(entity.getGroupDetailMeaning())
                .build();
    }
} 