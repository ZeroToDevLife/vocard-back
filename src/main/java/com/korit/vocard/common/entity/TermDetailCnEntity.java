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
@Table(name = "term_detail_cn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDetailCnEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "terms_id")
  private TermsEntity terms;

  @Column(name = "word")
  private String word;

  @Column(name = "meaning")
  private String meaning;

  @Column(name = "phonetic")
  private String phonetic;

  @Column(name = "example")
  private String example;

  @Column(name = "example_meaning")
  private String exampleMeaning;
  
}
