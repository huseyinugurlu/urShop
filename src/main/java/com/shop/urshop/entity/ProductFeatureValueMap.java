package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product_feature_value_map")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductFeatureValueMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "feature_value_id")
    private FeatureValue featureValue;

}
