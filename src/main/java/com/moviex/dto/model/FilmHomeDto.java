package com.moviex.dto.model;

import java.util.List;

public class FilmHomeDto {
    private String id;
    private String name;
    private List<FilmCategoryDto> movies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilmCategoryDto> getMovies() {
        return movies;
    }

    public void setMovies(List<FilmCategoryDto> movies) {
        this.movies = movies;
    }
}
