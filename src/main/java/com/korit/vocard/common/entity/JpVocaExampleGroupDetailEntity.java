package com.korit.vocard.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jp_voca_example_group_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExampleGroupDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private JpVocaExampleGroupEntity jpVocaExampleGroup;

    @Column(name = "group_detail_example", columnDefinition = "TEXT")
    private String groupDetailExample;

    @Column(name = "group_detail_meaning", columnDefinition = "TEXT")
    private String groupDetailMeaning;
} 