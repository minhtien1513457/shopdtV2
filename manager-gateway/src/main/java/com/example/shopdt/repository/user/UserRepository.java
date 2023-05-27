package com.example.shopdt.repository.user;

import com.example.shopdt.dto.UserDto;
import com.example.shopdt.entity.UserEntity;
import com.example.shopdt.repository.BaseRepository;
import org.springframework.data.util.Pair;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailIgnoreCase(String email);

    Optional<UserDto> findByIdAndTurnBackRole(String id);
}