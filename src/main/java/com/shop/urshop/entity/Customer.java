package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "customer")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends User {

  @Column(name = "number")
  private int customerNumber;

  @JsonIgnore
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private Set<Order> order;

  @JsonIgnore
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private Set<PaymentCard> paymentCard;

}
