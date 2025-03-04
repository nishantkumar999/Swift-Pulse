package com.accioshoppingbackend.Shopping_Backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        UUID id;
        @ManyToOne /// multiple products can buy by same userid ex- usertype can be shopper or sellerApplicationUser shopper;
        ApplicationUser shopper;
        Date orderPlaced;
        Date expectedDelivery;
        String status;
        int totalAmount;
        String paymentMethod;
        int totalQuantity;
        @OneToMany  ///ek userid par many products le skta h
        List<Product> products;
}
