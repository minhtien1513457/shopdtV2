package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.QUserEntity;
import com.example.shopdt.entity.UserEntity;
import com.example.shopdt.repository.UserRepository;
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
                .where(QUserEntity.userEntity.email.equalsIgnoreCase(email))
                .fetchFirst());
    }
}
