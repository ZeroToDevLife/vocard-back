package com.korit.vocard.common.entity;

import java.util.List;
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
@Table(name = "jp_voca_examples")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExamples {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "term_detail_id")
  private TermDetailJpVoca termDetailJpVoca;

  @Column(name = "part_speech")
  private String partSpeech;

  @OneToMany(mappedBy = "jpVocaExamples", cascade = CascadeType.ALL)
  private Set<JpVocaExampleGroup> jpVocaExampleGroup;

}
