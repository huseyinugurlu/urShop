package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "payment_card")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cardNumber")
    private long cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "cvv")
    private int cvv;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
