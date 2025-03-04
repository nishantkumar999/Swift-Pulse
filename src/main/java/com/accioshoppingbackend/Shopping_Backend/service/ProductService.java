package com.accioshoppingbackend.Shopping_Backend.service;

import com.accioshoppingbackend.Shopping_Backend.model.Product;
import com.accioshoppingbackend.Shopping_Backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;
    public List<Product> SearchByProductName(String productName, String sort) {
        if(sort.equals("asc"))
        {
            return productRepository.searchProductByNameASC();
        }
    }

    public List<Product> SearchByProductCategory(String productCategory, String sort) {
        return  productRepository.searchProductByCategoryDESC();
    }


}
