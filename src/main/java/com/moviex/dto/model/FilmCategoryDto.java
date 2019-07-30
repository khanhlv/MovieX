package com.moviex.dto.model;

public class FilmCategoryDto {
    private String id;
    private String filmNameVN;
    private String filmNameEN;
    private String filmDescription;
    private String filmImageThumb;
    private String filmImageMedium;
    private String filmView;
    private String filmIMDB;

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

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public String getFilmImageThumb() {
        return filmImageThumb;
    }

    public void setFilmImageThumb(String filmImageThumb) {
        this.filmImageThumb = filmImageThumb;
    }

    public String getFilmImageMedium() {
        return filmImageMedium;
    }

    public void setFilmImageMedium(String filmImageMedium) {
        this.filmImageMedium = filmImageMedium;
    }

    public String getFilmView() {
        return filmView;
    }

    public void setFilmView(String filmView) {
        this.filmView = filmView;
    }

    public String getFilmIMDB() {
        return filmIMDB;
    }

    public void setFilmIMDB(String filmIMDB) {
        this.filmIMDB = filmIMDB;
    }
}
