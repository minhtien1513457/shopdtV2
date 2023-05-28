package com.example.shopdt.use_case.user.service;

import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.use_case.user.request.CreateUserRequest;

public interface UserService {
    void create(CreateUserRequest request);
    UserDto getById(String id);
}
