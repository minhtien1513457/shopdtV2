package com.example.shopdt.use_case.cart.service;

import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.request.cart.CreateCartRequest;

public interface CartService {
    void create(CreateCartRequest request);

    UserDto getByUserId(String userId);
}
