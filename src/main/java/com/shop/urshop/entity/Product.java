package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private float price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductFeatureValueMap> productFeatureValueMap;

    @ManyToOne
    @JoinColumn(name = "customer_offer_id")
    private CustomerOffer customerOffer;

}
