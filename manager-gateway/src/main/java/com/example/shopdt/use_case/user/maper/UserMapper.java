package com.example.shopdt.use_case.user.maper;

import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.use_case.user.entity.UserEntity;
import com.example.shopdt.request.user.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto map(UserEntity userEntity);

    UserEntity map(CreateUserRequest request);

}
