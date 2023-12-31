package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "feature_values")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeatureValue {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "feature_id")
  private Feature feature;

  @JsonIgnore
  @OneToMany(mappedBy = "featureValue")
  private Set<ProductFeatureValueMap> productFeatureValueMap;
}
