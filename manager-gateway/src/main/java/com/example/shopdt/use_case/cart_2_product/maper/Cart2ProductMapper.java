package com.example.shopdt.use_case.cart_2_product.maper;

import com.example.shopdt.use_case.cart_2_product.entity.Cart2ProductEntity;
import com.example.shopdt.use_case.cart_2_product.request.AddProduct2CartRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Cart2ProductMapper {
    Cart2ProductMapper INSTANCE = Mappers.getMapper(Cart2ProductMapper.class);

    Cart2ProductEntity map(AddProduct2CartRequest request);
}
