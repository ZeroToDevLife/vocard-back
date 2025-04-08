package com.korit.vocard.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "jpVocaExamples")
@Table(name = "jp_voca_examples")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExamples {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "term_detail_id")
  private Integer termDetailId;

  @Column(name = "part_speech")
  private String partSpeech;
  
}
