package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category extends BaseModel {
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "CATEGORY_DESCRIPTION")
    private String categoryDescription;

    @Column(name = "CATEGORY_PARENT")
    private Long categoryParent;

    @Column(name = "CATEGORY_ORDER")
    private Long categoryOrder;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Long getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(Long categoryParent) {
        this.categoryParent = categoryParent;
    }

    public Long getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Long categoryOrder) {
        this.categoryOrder = categoryOrder;
    }
}
