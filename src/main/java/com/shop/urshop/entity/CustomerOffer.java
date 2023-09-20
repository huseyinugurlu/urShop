package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "customer_offer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_amount")
    private float totalAmount;

    @JsonIgnore
    @OneToMany(mappedBy = "customerOffer", cascade = CascadeType.ALL)
    private Set<Product> products;


}
