package com.navin.backend.e_market.controller;

import com.navin.backend.e_market.entity.Cart;
import com.navin.backend.e_market.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{customerId}/{addressId}")
    public ResponseEntity<Cart> createCart(long customerId,long addressId)
    {
        Cart cart=cartService.createCart(customerId,addressId);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PostMapping("/{custId}]/{productId}/{quantity}")
    public ResponseEntity<Cart> addToCart(@PathVariable long custId,
                                          @PathVariable long productId,
                                          @PathVariable int quantity)
    {

        Cart cart=cartService.additemToCart(custId,productId,quantity);
        return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }

    @DeleteMapping("/{cartId}/{itemId}")
    public ResponseEntity<Cart> removeItem(@PathVariable long cartId,@PathVariable long itemId)
    {
        Cart cart=cartService.removeItemFromCart(cartId,itemId);
        return new ResponseEntity<>(cart,HttpStatus.OK);

    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable long cartId)
    {
        Cart cart=cartService.getCart(cartId);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }


}
