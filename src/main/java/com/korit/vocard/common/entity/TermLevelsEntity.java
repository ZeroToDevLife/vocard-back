package com.korit.vocard.common.entity;

import java.util.List;

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
@Table(name = "term_levels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermLevelsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private TermBooksEntity termBooks;

  @Column(name = "level")
  private String level;

  @OneToMany(mappedBy = "termLevels", cascade = CascadeType.ALL)
  private List<TermDaysEntity> termDays;
}
