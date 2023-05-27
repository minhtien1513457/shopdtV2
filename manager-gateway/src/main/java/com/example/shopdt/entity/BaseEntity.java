package com.example.shopdt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    @PrePersist
    public void initializePublicId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
