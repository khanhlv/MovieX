package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM_EPISODE")
public class FilmEpisode extends BaseModel {
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "FILM_EPISODE_ID")
    private Long filmEpisodeId;

    @Column(name = "FILM_ID")
    private Long filmId;

    @Column(name = "FILM_EPISODE_NAME")
    private String filmEpisodeName;

    @Column(name = "FILM_EPISODE_ORDER")
    private Long filmEpisodeOrder;

    @Column(name = "FILM_EPISODE_VIEW")
    private Long filmEpisodeView;

    public Long getFilmEpisodeId() {
        return filmEpisodeId;
    }

    public void setFilmEpisodeId(Long filmEpisodeId) {
        this.filmEpisodeId = filmEpisodeId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getFilmEpisodeName() {
        return filmEpisodeName;
    }

    public void setFilmEpisodeName(String filmEpisodeName) {
        this.filmEpisodeName = filmEpisodeName;
    }

    public Long getFilmEpisodeOrder() {
        return filmEpisodeOrder;
    }

    public void setFilmEpisodeOrder(Long filmEpisodeOrder) {
        this.filmEpisodeOrder = filmEpisodeOrder;
    }

    public Long getFilmEpisodeView() {
        return filmEpisodeView;
    }

    public void setFilmEpisodeView(Long filmEpisodeView) {
        this.filmEpisodeView = filmEpisodeView;
    }
}
