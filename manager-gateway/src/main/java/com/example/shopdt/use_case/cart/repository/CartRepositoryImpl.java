package com.example.shopdt.use_case.cart.repository;

import com.example.shopdt.use_case.cart.entity.CartEntity;
import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl extends BaseRepositoryImpl<CartEntity, String> implements CartRepository {
    public CartRepositoryImpl(EntityManager em) {
        super(CartEntity.class, em);
    }
}
