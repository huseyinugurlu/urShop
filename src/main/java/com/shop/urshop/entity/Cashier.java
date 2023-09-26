package com.shop.urshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "cashier")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cashier extends User {
    @Column(name = "number")
    private int cashierNumber;
}
