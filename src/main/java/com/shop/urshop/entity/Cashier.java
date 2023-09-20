package com.shop.urshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cashier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cashier extends User {
    @Column(name = "number")
    private int cashierNumber;
}
