package com.moviex.dto.model;

public class FilmDto {
    private String id;
    private String filmNameVN;
    private String filmNameEN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmNameVN() {
        return filmNameVN;
    }

    public void setFilmNameVN(String filmNameVN) {
        this.filmNameVN = filmNameVN;
    }

    public String getFilmNameEN() {
        return filmNameEN;
    }

    public void setFilmNameEN(String filmNameEN) {
        this.filmNameEN = filmNameEN;
    }
}
