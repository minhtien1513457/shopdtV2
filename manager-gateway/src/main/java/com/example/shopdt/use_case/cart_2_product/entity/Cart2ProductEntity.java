package com.example.shopdt.use_case.cart_2_product.entity;

import com.example.shopdt.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carts_products")
public class Cart2ProductEntity extends BaseEntity {
    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "cart_id", nullable = false)
    private String cartId;

    @Column(name = "amount", nullable = false)
    private Integer amount;
}
