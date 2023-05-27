package com.example.shopdt.repository.product;

import com.example.shopdt.dto.ProductDto;
import com.example.shopdt.dto.UserDto;
import com.example.shopdt.entity.ProductEntity;
import com.example.shopdt.repository.BaseRepository;

import java.util.Optional;

public interface ProductRepository extends BaseRepository<ProductEntity, String> {
    Optional<ProductDto> findByIdAndTurnManufacturer(String id);
}