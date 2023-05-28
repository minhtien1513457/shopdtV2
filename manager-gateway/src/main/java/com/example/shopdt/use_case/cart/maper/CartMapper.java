package com.example.shopdt.use_case.cart.maper;

import com.example.shopdt.use_case.cart.dto.CartDto;
import com.example.shopdt.use_case.cart.entity.CartEntity;
import com.example.shopdt.use_case.cart.request.CreateCartRequest;
import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.entity.ProductEntity;
import com.example.shopdt.use_case.product.request.CreateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDto map(CartEntity entity);

    CartEntity map(CreateCartRequest request);

}
