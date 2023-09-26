package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "usr")
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "creation_date")
    private LocalDate creationDate;

}
