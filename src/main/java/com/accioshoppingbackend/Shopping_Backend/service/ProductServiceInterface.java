package com.accioshoppingbackend.Shopping_Backend.service;

import com.accioshoppingbackend.Shopping_Backend.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    public List<Product> SearchByProduct(String productName);
    public List<Product> SearchByCategory(String productCategory);
}
