package com.freshshop.ecommerce.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "order_products", schema = "freshshop")
public class OrderProduct {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Order order;

    @Column(name = "id")
    private String stockKeepingUnit;

    @Column(name = "id")
    private String name;

    @Column(name = "id")
    private String description;

    @Column(name = "id")
    private BigDecimal price;

    @Column(name = "id")
    private int quantity;

    @Column(name = "id")
    private BigDecimal subtotal;


    public OrderProduct() {
    }

    public OrderProduct(Long id, Order order, String stockKeepingUnit, String name, String description, BigDecimal price, int quantity, BigDecimal subtotal) {
        this.id = id;
        this.order = order;
        this.stockKeepingUnit = stockKeepingUnit;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStockKeepingUnit() {
        return this.stockKeepingUnit;
    }

    public void setStockKeepingUnit(String stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public OrderProduct id(Long id) {
        this.id = id;
        return this;
    }

    public OrderProduct order(Order order) {
        this.order = order;
        return this;
    }

    public OrderProduct stockKeepingUnit(String stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
        return this;
    }

    public OrderProduct name(String name) {
        this.name = name;
        return this;
    }

    public OrderProduct description(String description) {
        this.description = description;
        return this;
    }

    public OrderProduct price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderProduct quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderProduct subtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderProduct)) {
            return false;
        }
        OrderProduct orderProduct = (OrderProduct) o;
        return Objects.equals(id, orderProduct.id) && Objects.equals(order, orderProduct.order) && Objects.equals(stockKeepingUnit, orderProduct.stockKeepingUnit) && Objects.equals(name, orderProduct.name) && Objects.equals(description, orderProduct.description) && Objects.equals(price, orderProduct.price) && quantity == orderProduct.quantity && Objects.equals(subtotal, orderProduct.subtotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, stockKeepingUnit, name, description, price, quantity, subtotal);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", order='" + getOrder() + "'" +
            ", stockKeepingUnit='" + getStockKeepingUnit() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", subtotal='" + getSubtotal() + "'" +
            "}";
    }
}