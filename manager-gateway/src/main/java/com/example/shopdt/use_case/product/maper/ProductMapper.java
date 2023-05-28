package com.example.shopdt.use_case.product.maper;

import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.entity.ProductEntity;
import com.example.shopdt.use_case.product.request.CreateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto map(ProductEntity entity);

    ProductEntity map(CreateProductRequest request);

}
