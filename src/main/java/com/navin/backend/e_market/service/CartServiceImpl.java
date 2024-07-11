package com.navin.backend.e_market.service;

import com.navin.backend.e_market.Repository.*;
import com.navin.backend.e_market.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerAddressRepo customerAddressRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Cart createCart(long custId, long custAddressId) {

        Customer customer=customerRepo
                .findById(custId)
                .orElseThrow(()->new RuntimeException("Customer not found"));

        CustomerAdress customerAdress=customerAddressRepo
                .findById(custAddressId)
                .orElseThrow(()->new RuntimeException("Customer Address Not Found"));

        Cart cart=new Cart();
        cart.setCustomer(customer);
        cart.setCustomerAdress(customerAdress);

        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart additemToCart(Long cartId, Long productId,int quantity) {

        Cart cart=cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("Cart not found For customer"));
        Product product=productRepo.findById(productId).orElseThrow(()->new RuntimeException("product not found"));

        CartItem cartItem=new CartItem();

        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cart.getItems().add(cartItem);

        return cartRepo.save(cart);
    }
    public Cart removeItemFromCart(long cartId,long itemId){
        Cart cart=cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("Cart not found"));
        CartItem cartItem=cartItemRepo.findById(itemId).orElseThrow(()->new RuntimeException("item not fount in cart"));

        cart.getItems().remove(cartItem);
        cartItemRepo.delete(cartItem);

        return cartRepo.save(cart);
    }

    public Cart getCart(long cartId){
        Cart cart=cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("cart not found"));

        return cart;
    }

}
