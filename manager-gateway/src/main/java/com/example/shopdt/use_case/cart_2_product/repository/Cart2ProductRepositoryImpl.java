package com.example.shopdt.use_case.cart_2_product.repository;

import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import com.example.shopdt.use_case.cart_2_product.entity.Cart2ProductEntity;
import com.example.shopdt.use_case.cart_2_product.repository.Cart2ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class Cart2ProductRepositoryImpl extends BaseRepositoryImpl<Cart2ProductEntity, String> implements Cart2ProductRepository {
    public Cart2ProductRepositoryImpl(EntityManager em) {
        super(Cart2ProductEntity.class, em);
    }
}
