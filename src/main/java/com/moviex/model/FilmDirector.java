package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM_DIRECTOR", schema = "dbo")
public class FilmDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_DIRECTOR_ID")
    private Long filmDirectorId;

    @Column(name = "DIRECTOR_ID")
    private Long directorId;

    @Column(name = "FILM_ID")
    private Long filmId;

    public Long getFilmDirectorId() {
        return filmDirectorId;
    }

    public void setFilmDirectorId(Long filmDirectorId) {
        this.filmDirectorId = filmDirectorId;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
}
