package com.accioshoppingbackend.Shopping_Backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String productCategory;
    int price;
    int quantity;
    @JsonIgnore
    @ManyToOne
    ApplicationUser seller;
    int quantitySold;
    Double rating;


}
