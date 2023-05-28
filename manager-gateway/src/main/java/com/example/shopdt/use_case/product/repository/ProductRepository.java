package com.example.shopdt.use_case.product.repository;

import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.entity.ProductEntity;
import com.example.shopdt.repository.BaseRepository;

import java.util.Optional;

public interface ProductRepository extends BaseRepository<ProductEntity, String> {
    Optional<ProductDto> findByIdAndTurnBackProductDto(String id);
}