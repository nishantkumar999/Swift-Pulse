package com.accioshoppingbackend.Shopping_Backend.requestbody;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MultiProductDTO {

    List<CreateProductDTO> products;
}
