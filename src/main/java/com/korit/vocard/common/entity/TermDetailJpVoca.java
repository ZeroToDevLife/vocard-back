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

@Entity(name = "termDetailJpVoca")
@Table(name = "term_detail_jp_voca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDetailJpVoca {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "terms_id")
  private Integer termsId;

  private String word;

  private String meaning;

  private String yomigana;
  
}
