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
@Table(name = "jp_voca_example_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpVocaExampleGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "example_id")
  private JpVocaExamples jpVocaExamples;

  @Column(name = "example_group")
  private String exampleGroup;

  @Column(name = "related_type")
  private String relatedType;

  @Column(name = "related")
  private String related;

  @OneToMany(mappedBy = "jpVocaExampleGroup", cascade = CascadeType.ALL)
  private List<JpVocaExampleGroupDetail> jpVocaExampleGroupDetail;
}
