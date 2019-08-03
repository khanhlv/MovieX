package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM_COMPANY", schema = "dbo")
public class FilmCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_COMPANY_ID")
    private Long filmCompanyId;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "FILM_ID")
    private Long filmId;

    public Long getFilmCompanyId() {
        return filmCompanyId;
    }

    public void setFilmCompanyId(Long filmCompanyId) {
        this.filmCompanyId = filmCompanyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
}
