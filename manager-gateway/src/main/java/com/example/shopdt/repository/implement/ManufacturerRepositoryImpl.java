package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.ManufacturerEntity;
import com.example.shopdt.entity.RoleEntity;
import com.example.shopdt.repository.ManufacturerRepository;
import com.example.shopdt.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerRepositoryImpl extends BaseRepositoryImpl<ManufacturerEntity, String> implements ManufacturerRepository {
    public ManufacturerRepositoryImpl(EntityManager em) {
        super(ManufacturerEntity.class, em);
    }
}
