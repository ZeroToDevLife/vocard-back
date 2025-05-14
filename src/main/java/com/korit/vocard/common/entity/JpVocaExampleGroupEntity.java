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
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jp_voca_example_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExampleGroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "example_id")
  private JpVocaExamplesEntity jpVocaExamples;

  @Column(name = "example_group")
  private String exampleGroup;

  @OneToMany(mappedBy = "exampleGroup", cascade = CascadeType.ALL)
  @OrderBy("exampleSubGroup ASC")
  private List<JpVocaExampleSubGroupEntity> exampleSubGroups;

  public Integer getId() {
    return id;
  }

  public JpVocaExamplesEntity getJpVocaExamples() {
    return jpVocaExamples;
  }

  public String getExampleGroup() {
    return exampleGroup;
  }
}
