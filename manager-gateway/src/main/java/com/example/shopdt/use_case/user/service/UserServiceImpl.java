package com.example.shopdt.use_case.user.service;

import com.example.shopdt.use_case.user.repository.UserRepository;
import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.use_case.user.maper.UserMapper;
import com.example.shopdt.request.user.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void create(CreateUserRequest request) {
        userRepository.save(UserMapper.INSTANCE.map(request));
    }

    @Override
    public UserDto getById(String id) {
        return userRepository.findByIdAndTurnBackRole(id)
                .orElseThrow(NotFoundException::new);
    }
}
