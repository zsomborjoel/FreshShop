package com.freshshop.ecommerce.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sessions", schema = "freshshop")
public class Session {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "data")
    private String data;

    public Session() {
    }

    public Session(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Session id(Long id) {
        this.id = id;
        return this;
    }

    public Session data(String data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Session)) {
            return false;
        }
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(data, session.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }

}
