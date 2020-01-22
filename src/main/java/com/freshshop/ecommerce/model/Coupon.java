package com.freshshop.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons", schema = "freshshop")
public class Coupon {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "multiple")
    private boolean multiple;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public Coupon() {
    }

    public Coupon(Long id, String code, String description, boolean active, BigDecimal value, boolean multiple, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.active = active;
        this.value = value;
        this.multiple = multiple;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isMultiple() {
        return this.multiple;
    }

    public boolean getMultiple() {
        return this.multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Coupon id(Long id) {
        this.id = id;
        return this;
    }

    public Coupon code(String code) {
        this.code = code;
        return this;
    }

    public Coupon description(String description) {
        this.description = description;
        return this;
    }

    public Coupon active(boolean active) {
        this.active = active;
        return this;
    }

    public Coupon value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public Coupon multiple(boolean multiple) {
        this.multiple = multiple;
        return this;
    }

    public Coupon startDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public Coupon endDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coupon)) {
            return false;
        }
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id) && Objects.equals(code, coupon.code) && Objects.equals(description, coupon.description) && active == coupon.active && Objects.equals(value, coupon.value) && multiple == coupon.multiple && Objects.equals(startDate, coupon.startDate) && Objects.equals(endDate, coupon.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description, active, value, multiple, startDate, endDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", active='" + isActive() + "'" +
            ", value='" + getValue() + "'" +
            ", multiple='" + isMultiple() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }

}
