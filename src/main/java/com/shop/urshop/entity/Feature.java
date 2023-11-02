package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "features")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feature {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "feature_name")
  private String name;

  @Column(name = "feature_code")
  private int code;

  @JsonIgnore
  @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
  private Set<FeatureValue> featureValue;
}
