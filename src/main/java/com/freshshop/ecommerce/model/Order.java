package com.freshshop.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "sales_orders", schema = "freshshop")
public class Order {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private LocalDate date;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coupon_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Coupon coupon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Order() {
    }

    public Order(Long id, LocalDate date, BigDecimal total, Coupon coupon, Session session, User user) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.coupon = coupon;
        this.session = session;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order id(Long id) {
        this.id = id;
        return this;
    }

    public Order date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Order total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public Order coupon(Coupon coupon) {
        this.coupon = coupon;
        return this;
    }

    public Order session(Session session) {
        this.session = session;
        return this;
    }

    public Order user(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(date, order.date) && Objects.equals(total, order.total) && Objects.equals(coupon, order.coupon) && Objects.equals(session, order.session) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, total, coupon, session, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", date='" + getDate() + "'" +
            ", total='" + getTotal() + "'" +
            ", coupon='" + getCoupon() + "'" +
            ", session='" + getSession() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}