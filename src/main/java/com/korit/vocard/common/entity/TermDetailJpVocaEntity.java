package com.korit.vocard.common.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "term_detail_jp_voca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDetailJpVocaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "terms_id")
  private TermsEntity terms;

  @Column(name = "word")
  private String word;

  @Column(name = "yomigana")
  private String yomigana;

  @Column(name = "meaning")
  private String meaning;

  @OneToMany(mappedBy = "termDetailJpVoca", cascade = CascadeType.ALL)
  private Set<JpVocaExamplesEntity> jpVocaExamples;

}
