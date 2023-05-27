package com.example.shopdt.repository.implement;

import com.example.shopdt.entity.ProductEntity;
import com.example.shopdt.repository.product.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<ProductEntity, String> implements ProductRepository {
    public ProductRepositoryImpl(EntityManager em) {
        super(ProductEntity.class, em);
    }
}
