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

@Entity(name = "termLevels")
@Table(name = "term_levels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermLevels {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "book_id")
  private Integer bookId;

  private String level;
  
}
