package com.korit.vocard.common.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "term_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermBooksEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "language")
  private String language;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "termBooks", cascade = CascadeType.ALL)
  private List<TermLevelsEntity> termLevels;

}