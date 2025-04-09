package com.korit.vocard.common.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "term_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDays {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "level_id")
  private TermLevels termLevels;

  @Column(name = "day_number")
  private Integer dayNumber;

  @OneToOne(mappedBy = "termDays", cascade = CascadeType.ALL)
  private Terms terms;
}
