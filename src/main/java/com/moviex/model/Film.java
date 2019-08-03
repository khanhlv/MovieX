package com.moviex.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FILM", schema = "dbo")
public class Film extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_ID")
    private Long filmId;

    @Column(name = "FILM_NAME_VN")
    private String filmNameVN;

    @Column(name = "FILM_NAME_EN")
    private String filmNameEN;

    @Column(name = "FILM_DESCRIPTION")
    private String filmDescription;

    @Column(name = "FILM_CONTENT")
    private String filmContent;

    @Column(name = "FILM_IMAGE_THUMB")
    private String filmImageThumb;

    @Column(name = "FILM_IMAGE_MEDIUM")
    private String filmImageMedium;

    @Column(name = "FILM_TRAILER")
    private String filmTrailer;

    @Column(name = "FILM_VIEW")
    private Long filmView;

    @Column(name = "FILM_IMDB")
    private Long filmIMDB;

    @Column(name = "FILM_YEAR")
    private Long filmYear;

    @Column(name = "FILM_COUNTRY")
    private String filmCountry;

    @Column(name = "FILM_RELEASE_DATE")
    private Date filmReleaseDate;

    @Column(name = "FILM_TIME")
    private Long filmTime;

    @Column(name = "FILM_EPISODE")
    private Long filmEpisode;

    @Column(name = "FILM_RESOLUTION")
    private String filmResolution;

    @Column(name = "FILM_STATUS")
    private Long filmStatus;

    @Column(name = "FILM_SOURCE")
    private String filmSource;

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

    public String getFilmContent() {
        return filmContent;
    }

    public void setFilmContent(String filmContent) {
        this.filmContent = filmContent;
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

    public String getFilmTrailer() {
        return filmTrailer;
    }

    public void setFilmTrailer(String filmTrailer) {
        this.filmTrailer = filmTrailer;
    }

    public Long getFilmView() {
        return filmView;
    }

    public void setFilmView(Long filmView) {
        this.filmView = filmView;
    }

    public Long getFilmIMDB() {
        return filmIMDB;
    }

    public void setFilmIMDB(Long filmIMDB) {
        this.filmIMDB = filmIMDB;
    }

    public Long getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(Long filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmCountry() {
        return filmCountry;
    }

    public void setFilmCountry(String filmCountry) {
        this.filmCountry = filmCountry;
    }

    public Date getFilmReleaseDate() {
        return filmReleaseDate;
    }

    public void setFilmReleaseDate(Date filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    public Long getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Long filmTime) {
        this.filmTime = filmTime;
    }

    public Long getFilmEpisode() {
        return filmEpisode;
    }

    public void setFilmEpisode(Long filmEpisode) {
        this.filmEpisode = filmEpisode;
    }

    public String getFilmResolution() {
        return filmResolution;
    }

    public void setFilmResolution(String filmResolution) {
        this.filmResolution = filmResolution;
    }

    public Long getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Long filmStatus) {
        this.filmStatus = filmStatus;
    }

    public String getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(String filmSource) {
        this.filmSource = filmSource;
    }
}
