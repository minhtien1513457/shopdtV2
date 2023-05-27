package com.example.shopdt.service.product;

import com.example.shopdt.dto.ProductDto;
import com.example.shopdt.dto.UserDto;
import com.example.shopdt.request.product.CreateProductRequest;
import com.example.shopdt.request.user.CreateUserRequest;

public interface ProdcutService {
    void create(CreateProductRequest request);
    ProductDto findByIdAndTurnManufacturer(String id);
}
