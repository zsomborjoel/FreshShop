package com.freshshop.ecommerce.model;

import java.math.BigDecimal;
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

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProductStatus productStatus;

    @Column(name = "regular_price")
    private BigDecimal regularPrice;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "taxable")
    private boolean taxable;

    @Column(name = "image")
    private String image;

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

    public Product(Long id, String sku, String name, String description, ProductStatus productStatus, BigDecimal regularPrice, BigDecimal discountPrice, Integer quantity, boolean taxable, String image, Set<Category> categories, Set<Tag> tags) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.productStatus = productStatus;
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.taxable = taxable;
        this.image = image;
        this.categories = categories;
        this.tags = tags;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public ProductStatus getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public BigDecimal getRegularPrice() {
        return this.regularPrice;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public BigDecimal getDiscountPrice() {
        return this.discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isTaxable() {
        return this.taxable;
    }

    public boolean getTaxable() {
        return this.taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
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
        this.id = id;
        return this;
    }

    public Product sku(String sku) {
        this.sku = sku;
        return this;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public Product productStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
        return this;
    }

    public Product regularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    public Product discountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
        return this;
    }

    public Product quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product taxable(boolean taxable) {
        this.taxable = taxable;
        return this;
    }

    public Product image(String image) {
        this.image = image;
        return this;
    }

    public Product categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Product tags(Set<Tag> tags) {
        this.tags = tags;
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
        return Objects.equals(id, product.id) && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(productStatus, product.productStatus) && Objects.equals(regularPrice, product.regularPrice) && Objects.equals(discountPrice, product.discountPrice) && Objects.equals(quantity, product.quantity) && taxable == product.taxable && Objects.equals(image, product.image) && Objects.equals(categories, product.categories) && Objects.equals(tags, product.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, description, productStatus, regularPrice, discountPrice, quantity, taxable, image, categories, tags);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", sku='" + getSku() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
            ", regularPrice='" + getRegularPrice() + "'" +
            ", discountPrice='" + getDiscountPrice() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", taxable='" + isTaxable() + "'" +
            ", image='" + getImage() + "'" +
            ", categories='" + getCategories() + "'" +
            ", tags='" + getTags() + "'" +
            "}";
    }


}