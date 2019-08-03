package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM_CATEGORY", schema = "dbo")
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_CATEGORY_ID")
    private Long filmCategoryId;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "FILM_ID")
    private Long filmId;

    public Long getFilmCategoryId() {
        return filmCategoryId;
    }

    public void setFilmCategoryId(Long filmCategoryId) {
        this.filmCategoryId = filmCategoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
}
