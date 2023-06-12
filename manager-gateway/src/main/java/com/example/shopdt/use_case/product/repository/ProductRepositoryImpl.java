package com.example.shopdt.use_case.product.repository;

import com.example.shopdt.repository.implement.BaseRepositoryImpl;
import com.example.shopdt.use_case.manufacturer.entity.QManufacturerEntity;
import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.entity.ProductEntity;
import com.example.shopdt.use_case.product.entity.QProductEntity;
import com.querydsl.core.types.Projections;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<ProductEntity, String> implements ProductRepository {
    public ProductRepositoryImpl(EntityManager em) {
        super(ProductEntity.class, em);
    }

    @Override
    public Optional<ProductDto> findByIdAndTurnBackProductDto(String id) {
        return Optional.ofNullable(queryFactory
                .select(Projections.bean(
                        ProductDto.class,
                        QProductEntity.productEntity.id.as(ProductDto.Fields.id),
                        QProductEntity.productEntity.name.as(ProductDto.Fields.name),
                        QProductEntity.productEntity.description.as(ProductDto.Fields.description),
                        QProductEntity.productEntity.status.as(ProductDto.Fields.status),
                        QProductEntity.productEntity.price.as(ProductDto.Fields.price),
                        QProductEntity.productEntity.total.as(ProductDto.Fields.total),
                        QManufacturerEntity.manufacturerEntity.id.as(ProductDto.Fields.manufacturerId),
                        QManufacturerEntity.manufacturerEntity.name.as(ProductDto.Fields.manufacturerName),
                        QProductEntity.productEntity.createdDate.as(ProductDto.Fields.createdDate),
                        QProductEntity.productEntity.updatedDate.as(ProductDto.Fields.updatedDate)
                ))
                .from(QProductEntity.productEntity)
                .innerJoin(QManufacturerEntity.manufacturerEntity)
                .on(QProductEntity.productEntity.manufacturerId.eq(QManufacturerEntity.manufacturerEntity.id))
                .where(QProductEntity.productEntity.id.eq(id))
                .fetchFirst());
    }
}
