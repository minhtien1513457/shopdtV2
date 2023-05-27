package com.example.shopdt.service.cart;

import com.example.shopdt.dto.UserDto;
import com.example.shopdt.request.cart.CreateCartRequest;
import com.example.shopdt.request.user.CreateUserRequest;

public interface CartService {
    void create(CreateCartRequest request);

    UserDto getByUserId(String userId);
}
