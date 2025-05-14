package com.korit.vocard.common.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jp_voca_example_sub_group")
@Getter
@NoArgsConstructor
public class JpVocaExampleSubGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "example_group_id")
    private JpVocaExampleGroupEntity exampleGroup;

    @Column(name = "example_sub_group")
    private String exampleSubGroup;

    @Column(name = "related_type")
    private String relatedType;

    @Column(name = "related")
    private String related;

    @OneToMany(mappedBy = "subGroup", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    private List<JpVocaExampleGroupDetailEntity> details;
} 