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

@Entity(name = "termDays")
@Table(name = "term_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermDays {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "level_id")
  private Integer levelId;

  @Column(name = "day_number")
  private Integer dayNumber;
  
}
