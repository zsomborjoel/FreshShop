package com.freshshop.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inserted_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at") 
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}