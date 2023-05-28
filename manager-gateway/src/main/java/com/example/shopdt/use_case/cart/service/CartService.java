package com.example.shopdt.use_case.cart.service;

import com.example.shopdt.use_case.cart.dto.CartDto;
import com.example.shopdt.use_case.cart.request.AddProduct2CartRequest;
import com.example.shopdt.use_case.cart.request.CreateCartRequest;

public interface CartService {
    void create(CreateCartRequest request);

    CartDto getByUserId(String userId);

    void addProduct2Cart(AddProduct2CartRequest request);
}
