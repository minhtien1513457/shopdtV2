package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.CartEntity;
import com.example.shopdt.entity.RoleEntity;
import com.example.shopdt.repository.CartRepository;
import com.example.shopdt.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl extends BaseRepositoryImpl<CartEntity, String> implements CartRepository {
    public CartRepositoryImpl(EntityManager em) {
        super(CartEntity.class, em);
    }
}
