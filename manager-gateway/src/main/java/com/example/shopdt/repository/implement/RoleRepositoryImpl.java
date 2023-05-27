package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.RoleEntity;
import com.example.shopdt.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl<RoleEntity, String> implements RoleRepository {
    public RoleRepositoryImpl(EntityManager em) {
        super(RoleEntity.class, em);
    }
}
