package com.example.shopdt.use_case.manufacturer.service;

import com.example.shopdt.use_case.manufacturer.entity.ManufacturerEntity;

import java.util.Optional;

public interface ManufacturerService {
    Optional<ManufacturerEntity> getByIdNullAble(String id);

    ManufacturerEntity getByIdNoneNull(String id);
}
