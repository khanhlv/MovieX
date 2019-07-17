package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM")
public class Film {
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "FILM_ID")
    private Long filmId;

    @Column(name = "FILM_NAME_VN")
    private String filmNameVN;

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getFilmNameVN() {
        return filmNameVN;
    }

    public void setFilmNameVN(String filmNameVN) {
        this.filmNameVN = filmNameVN;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmNameVN='" + filmNameVN + '\'' +
                '}';
    }
}
