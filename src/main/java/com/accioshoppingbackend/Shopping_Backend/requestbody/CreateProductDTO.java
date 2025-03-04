package com.accioshoppingbackend.Shopping_Backend.requestbody;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateProductDTO {
    String productName;
    String productCategory;
    int price;
    int quantity;
}
