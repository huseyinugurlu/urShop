package com.shop.urshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.*;

@Table(name = "ordrs")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "total_amount")
  private float totalAmount;

  @Column(name = "order_date")
  private LocalDate orderDate;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @JsonIgnore
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<OrderItem> orderItem;
}
