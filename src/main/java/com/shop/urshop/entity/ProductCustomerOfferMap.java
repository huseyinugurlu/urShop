package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product_customer_offer_maps")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCustomerOfferMap {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "customer_offer_id")
  private CustomerOffer customerOffer;
}
