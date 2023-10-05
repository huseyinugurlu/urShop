package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "product_customer_offer_map")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCustomerOfferMap {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int mapId;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "customer_offer_id")
  private CustomerOffer customerOffer;
}
