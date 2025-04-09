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

@Entity(name = "jpVocaExampleGroup")
@Table(name = "jp_voca_example_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExampleGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "example_id")
  private Integer exampleId;

  @Column(name = "example_group")
  private String exampleGroup;

  @Column(name = "related_type")
  private String relatedType;

  private String related;
  
}
