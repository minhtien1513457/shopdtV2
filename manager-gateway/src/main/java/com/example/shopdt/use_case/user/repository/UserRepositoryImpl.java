package com.example.shopdt.use_case.user.repository;

import com.example.shopdt.use_case.user.dto.UserDto;
import com.example.shopdt.entity.QRoleEntity;
import com.example.shopdt.entity.QUserEntity;
import com.example.shopdt.use_case.user.entity.UserEntity;
import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import com.querydsl.core.types.Projections;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<UserEntity, String> implements UserRepository {
    public UserRepositoryImpl(EntityManager em) {
        super(UserEntity.class, em);
    }

    @Override
    public Optional<UserEntity> findByEmailIgnoreCase(String email) {
        return Optional.ofNullable(queryFactory
                .select(QUserEntity.userEntity)
                .from(QUserEntity.userEntity)
                .innerJoin(QRoleEntity.roleEntity)
                .on(QUserEntity.userEntity.roleId.eq(QRoleEntity.roleEntity.id))
                .where(QUserEntity.userEntity.email.equalsIgnoreCase(email))
                .fetchFirst());
    }

    @Override
    public Optional<UserDto> findByIdAndTurnBackRole(String id) {
        return Optional.ofNullable(queryFactory
                .select(Projections.bean(
                        UserDto.class,
                        QUserEntity.userEntity.id.as(UserDto.Fields.id),
                        QUserEntity.userEntity.username.as(UserDto.Fields.username),
                        QUserEntity.userEntity.email.as(UserDto.Fields.email),
                        QRoleEntity.roleEntity.name.as(UserDto.Fields.roleName),
                        QRoleEntity.roleEntity.createdDate.as(UserDto.Fields.createdDate),
                        QRoleEntity.roleEntity.updatedDate.as(UserDto.Fields.updatedDate)
                ))
                .from(QUserEntity.userEntity)
                .innerJoin(QRoleEntity.roleEntity)
                .on(QUserEntity.userEntity.roleId.eq(QRoleEntity.roleEntity.id))
                .where(QUserEntity.userEntity.id.eq(id))
                .fetchFirst());
    }
}
