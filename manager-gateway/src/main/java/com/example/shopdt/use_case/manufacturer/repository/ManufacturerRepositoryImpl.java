package com.example.shopdt.use_case.manufacturer.repository;

import com.example.shopdt.use_case.manufacturer.entity.ManufacturerEntity;
import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerRepositoryImpl extends BaseRepositoryImpl<ManufacturerEntity, String> implements ManufacturerRepository {
    public ManufacturerRepositoryImpl(EntityManager em) {
        super(ManufacturerEntity.class, em);
    }
}
