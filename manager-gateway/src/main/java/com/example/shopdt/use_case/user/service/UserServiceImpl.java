package com.example.shopdt.use_case.user.service;

import com.example.shopdt.use_case.cart.request.CreateCartRequest;
import com.example.shopdt.use_case.cart.service.CartService;
import com.example.shopdt.use_case.user.entity.UserEntity;
import com.example.shopdt.use_case.user.repository.UserRepository;
import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.use_case.user.maper.UserMapper;
import com.example.shopdt.use_case.user.request.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final CartService cartService;

    @Override
    @Transactional
    public void create(CreateUserRequest request) {
        UserEntity userEntity = userRepository.save(UserMapper.INSTANCE.map(request));
        cartService.create(CreateCartRequest.builder()
                .userId(userEntity.getId()).build());
    }

    @Override
    public UserDto getById(String id) {
        return userRepository.findByIdAndTurnBackRole(id)
                .orElseThrow(NotFoundException::new);
    }
}
