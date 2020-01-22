package com.freshshop.ecommerce.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_statuses", schema = "freshshop")
class ProductStatus {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public ProductStatus() {
    }

    public ProductStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus id(Long id) {
        this.id = id;
        return this;
    }

    public ProductStatus name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductStatus)) {
            return false;
        }
        ProductStatus productStatus = (ProductStatus) o;
        return Objects.equals(id, productStatus.id) && Objects.equals(name, productStatus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}