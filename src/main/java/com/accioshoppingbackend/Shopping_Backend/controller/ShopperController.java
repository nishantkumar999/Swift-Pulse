package com.accioshoppingbackend.Shopping_Backend.controller;

import com.accioshoppingbackend.Shopping_Backend.enums.SortEnum;
import com.accioshoppingbackend.Shopping_Backend.exception.InvalidProductException;
import com.accioshoppingbackend.Shopping_Backend.exception.UserNotAllowed;
import com.accioshoppingbackend.Shopping_Backend.exception.UserNotFound;
import com.accioshoppingbackend.Shopping_Backend.model.Product;
import com.accioshoppingbackend.Shopping_Backend.requestbody.PlaceOrderDTO;
import com.accioshoppingbackend.Shopping_Backend.responsebody.BillResponseBody;
import com.accioshoppingbackend.Shopping_Backend.service.OrderService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/shopper")
public class ShopperController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO, @RequestParam String shopperEmail){

        try{
            BillResponseBody bill = orderService.placeOrder(placeOrderDTO, shopperEmail);
            return new ResponseEntity(bill, HttpStatus.CREATED);
        }
        catch (UserNotFound e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (UserNotAllowed e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        catch (InvalidProductException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/order/history")
    public List<List<Product>> getShopperOrderHistory(@RequestParam String shopperEmail){
        return orderService.getShopperOrderHistory(shopperEmail);
    }

    @PutMapping("/order/cancel")
    public void cancelOrder(@RequestParam String shopperEmail,
                            @RequestParam UUID orderID){
        orderService.cancelOrder(shopperEmail, orderID);
    }

    @GetMapping("/")
    public List<Product> searchProduct(@RequestParam(required = false) String search_product,
                                       @RequestParam(required = false) String search_category,
                                       @RequestParam(required = true) SortEnum sort){

    }
}
