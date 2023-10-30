package com.shop.urshop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Table(name = "usrs")
@Getter
@SuperBuilder
@Setter
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
  private String name;

  @Column(name = "e_mail")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "authority")
  private String authority;

  @Column(name = "creation_date")
  private String creationDate;
}
