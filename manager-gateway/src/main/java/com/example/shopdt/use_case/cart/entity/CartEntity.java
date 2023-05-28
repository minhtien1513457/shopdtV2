package com.example.shopdt.use_case.cart.entity;

import com.example.shopdt.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carts")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE carts SET deleted_at=NOW() WHERE id=?")
public class CartEntity extends BaseEntity {
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "deleted_at")
    private Date deletedAt;
}
