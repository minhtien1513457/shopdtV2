package com.example.shopdt.service.user;

import com.example.shopdt.dto.UserDto;
import com.example.shopdt.request.user.CreateUserRequest;

public interface UserService {
    void create(CreateUserRequest request);
    UserDto getById(String id);
}
