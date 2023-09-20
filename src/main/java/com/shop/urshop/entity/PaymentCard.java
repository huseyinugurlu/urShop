package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "payment_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private long cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "cvv")
    private int cvv;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
