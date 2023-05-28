package com.example.shopdt.use_case.product.service;

import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.request.CreateProductRequest;

public interface ProductService {
    void create(CreateProductRequest request);
    ProductDto findByIdAndTurnManufacturer(String id);
}
