package com.example.shopdt.use_case.product.entity;

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
@Table(name = "products")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE products SET deleted_at=NOW() WHERE id=?")
public class ProductEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "manufacturer_id", nullable = false)
    private String manufacturerId;

    @Column(name = "deleted_at")
    private Date deletedAt;
}
