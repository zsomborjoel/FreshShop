package com.freshshop.ecommerce.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products", schema = "freshshop")
public class Product {
    
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProductStatus productStatus;

    @Column(name = "company")
    private String company;

    @Column(name ="info")
    private String info;

    @Column(name = "inCart")
    private Boolean inCart;

    @Column(name = "count")
    private Integer count;

    @Column(name = "total")
    private Integer total;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_categories", schema = "freshshop",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tags", schema = "freshshop",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String title, String img, Integer price, ProductStatus productStatus, String company, String info, Boolean inCart, Integer count, Integer total, Set<Category> categories, Set<Tag> tags) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.price = price;
        this.productStatus = productStatus;
        this.company = company;
        this.info = info;
        this.inCart = inCart;
        this.count = count;
        this.total = total;
        this.categories = categories;
        this.tags = tags;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductStatus getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean isInCart() {
        return this.inCart;
    }

    public Boolean getInCart() {
        return this.inCart;
    }

    public void setInCart(Boolean inCart) {
        this.inCart = inCart;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Product id(Long id) {
        setId(id);
        return this;
    }

    public Product title(String title) {
        setTitle(title);
        return this;
    }

    public Product img(String img) {
        setImg(img);
        return this;
    }

    public Product price(Integer price) {
        setPrice(price);
        return this;
    }

    public Product productStatus(ProductStatus productStatus) {
        setProductStatus(productStatus);
        return this;
    }

    public Product company(String company) {
        setCompany(company);
        return this;
    }

    public Product info(String info) {
        setInfo(info);
        return this;
    }

    public Product inCart(Boolean inCart) {
        setInCart(inCart);
        return this;
    }

    public Product count(Integer count) {
        setCount(count);
        return this;
    }

    public Product total(Integer total) {
        setTotal(total);
        return this;
    }

    public Product categories(Set<Category> categories) {
        setCategories(categories);
        return this;
    }

    public Product tags(Set<Tag> tags) {
        setTags(tags);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(img, product.img) && Objects.equals(price, product.price) && Objects.equals(productStatus, product.productStatus) && Objects.equals(company, product.company) && Objects.equals(info, product.info) && Objects.equals(inCart, product.inCart) && Objects.equals(count, product.count) && Objects.equals(total, product.total) && Objects.equals(categories, product.categories) && Objects.equals(tags, product.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, img, price, productStatus, company, info, inCart, count, total, categories, tags);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", img='" + getImg() + "'" +
            ", price='" + getPrice() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
            ", company='" + getCompany() + "'" +
            ", info='" + getInfo() + "'" +
            ", inCart='" + isInCart() + "'" +
            ", count='" + getCount() + "'" +
            ", total='" + getTotal() + "'" +
            ", categories='" + getCategories() + "'" +
            ", tags='" + getTags() + "'" +
            "}";
    }

}