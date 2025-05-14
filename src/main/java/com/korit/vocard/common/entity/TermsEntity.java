package com.korit.vocard.common.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "terms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne
  @JoinColumn(name = "day_id")
  private TermDaysEntity termDays;

  @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
  private List<TermDetailJpVocaEntity> termDetailJpVoca;

  @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
  private List<TermDetailJpKanjiEntity> termDetailJpKanji;

  @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
  private List<TermDetailEnEntity> termDetailEn;

  @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
  private List<TermDetailCnEntity> termDetailCn;
  
}
