package com.accioshoppingbackend.Shopping_Backend.service;

import com.accioshoppingbackend.Shopping_Backend.exception.UserNotAllowed;
import com.accioshoppingbackend.Shopping_Backend.exception.UserNotFound;
import com.accioshoppingbackend.Shopping_Backend.model.ApplicationUser;
import com.accioshoppingbackend.Shopping_Backend.model.Product;
import com.accioshoppingbackend.Shopping_Backend.repository.ProductRepository;
import com.accioshoppingbackend.Shopping_Backend.requestbody.CreateProductDTO;
import com.accioshoppingbackend.Shopping_Backend.requestbody.MultiProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    UserUtil userUtil;

    @Autowired
    Mapper mapper;

    @Autowired
    ProductRepository productRepository;

    public void createProduct(CreateProductDTO createProductDTO,
                              String sellerEmail){

        ApplicationUser user = userUtil.checkEmailExists(sellerEmail);
        boolean isSeller = userUtil.isSeller(user);

        if(user == null){
            throw new UserNotFound(String.format("Seller with email %s does not exist in system", sellerEmail));
        }

        if(isSeller == false){
            throw new UserNotAllowed(String.format("User with email %s does not allowed to add product", sellerEmail));
        }

        Product product = mapper.productMapper(createProductDTO, user);
        productRepository.save(product);
    }

    public  void createMultiProduct(MultiProductDTO multiProductDTO,
                                    String sellerEmail){

        ApplicationUser user = userUtil.checkEmailExists(sellerEmail);
        boolean isSeller = userUtil.isSeller(user);

        if(user == null){
            throw new UserNotFound(String.format("Seller with email %s does not exist in system", sellerEmail));
        }

        if(isSeller == false)
            throw new UserNotAllowed(String.format("User with email %s does not allowed to add product", sellerEmail));

        List<CreateProductDTO> productDTOS = multiProductDTO.getProducts();

        for(CreateProductDTO productDTO : productDTOS){
            Product product = mapper.productMapper(productDTO, user);
            productRepository.save(product);
        }
    }
}
