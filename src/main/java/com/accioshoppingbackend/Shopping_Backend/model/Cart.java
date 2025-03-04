package com.accioshoppingbackend.Shopping_Backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @OneToOne /// ek user ka ek cart ho sakta aur har cart ek user ke sath map ha
    ApplicationUser shopper;
    int totalAmount;
    int totalQuantity;
    @OneToMany/// ek cart par multiple products hote ha
    List<Product> products;
}
