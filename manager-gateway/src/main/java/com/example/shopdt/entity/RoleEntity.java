package com.example.shopdt.entity;

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
@Table(name = "roles")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE roles SET deleted_at=NOW() WHERE id=?")
public class RoleEntity extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted_at")
    private Date deletedAt;
}
