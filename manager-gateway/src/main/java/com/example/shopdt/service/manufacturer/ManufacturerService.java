package com.example.shopdt.service.manufacturer;

import com.example.shopdt.entity.ManufacturerEntity;

import java.util.Optional;

public interface ManufacturerService {
    Optional<ManufacturerEntity> getByIdNullAble(String id);

    ManufacturerEntity getByIdNoneNull(String id);
}
