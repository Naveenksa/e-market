package com.navin.backend.e_market.service;

import com.navin.backend.e_market.entity.Cart;
import com.navin.backend.e_market.entity.Product;

public interface CartService {

    Cart createCart(long custId,long custAddressId);
    Cart additemToCart(Long cartId, Long proDuctId,int quantity);
    Cart removeItemFromCart(long cartId,long itemId);
}
