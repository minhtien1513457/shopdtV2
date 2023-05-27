package com.example.shopdt.repository.manufacturer;

import com.example.shopdt.entity.ManufacturerEntity;
import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import com.example.shopdt.repository.manufacturer.ManufacturerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerRepositoryImpl extends BaseRepositoryImpl<ManufacturerEntity, String> implements ManufacturerRepository {
    public ManufacturerRepositoryImpl(EntityManager em) {
        super(ManufacturerEntity.class, em);
    }
}
