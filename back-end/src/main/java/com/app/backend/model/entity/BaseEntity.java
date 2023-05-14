package com.app.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @PrePersist
    void preInsert() {
        if (createAt != null) {
            this.updateAt = LocalDateTime.now();
        }

        this.createAt = LocalDateTime.now();

    }
}
