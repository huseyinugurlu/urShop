package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "customer_offers")
@Getter
@Builder
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
  @OneToMany(mappedBy = "customerOffer")
  private Set<ProductCustomerOfferMap> productCustomerOfferMaps;
}
