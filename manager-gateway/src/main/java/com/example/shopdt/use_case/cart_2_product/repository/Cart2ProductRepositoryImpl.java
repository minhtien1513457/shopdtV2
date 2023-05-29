package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.Cart2ProductEntity;
import com.example.shopdt.entity.RoleEntity;
import com.example.shopdt.repository.Cart2ProductRepository;
import com.example.shopdt.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class Cart2ProductRepositoryImpl extends BaseRepositoryImpl<Cart2ProductEntity, String> implements Cart2ProductRepository {
    public Cart2ProductRepositoryImpl(EntityManager em) {
        super(Cart2ProductEntity.class, em);
    }
}
