package com.example.shopdt.repository;

import com.example.shopdt.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailIgnoreCase(String email);
}