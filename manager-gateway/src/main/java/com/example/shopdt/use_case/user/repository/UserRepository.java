package com.example.shopdt.use_case.user.repository;

import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.use_case.user.entity.UserEntity;
import com.example.shopdt.repository.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailIgnoreCase(String email);

    Optional<UserDto> findByIdAndTurnBackRole(String id);
}