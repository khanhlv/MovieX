package com.moviex.dto.model;

public class FilmEpisodeDto {
    private String id;
    private String filmId;
    private String filmEpisodeName;
    private String filmEpisodeOrder;
    private String filmEpisodeView;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmEpisodeName() {
        return filmEpisodeName;
    }

    public void setFilmEpisodeName(String filmEpisodeName) {
        this.filmEpisodeName = filmEpisodeName;
    }

    public String getFilmEpisodeOrder() {
        return filmEpisodeOrder;
    }

    public void setFilmEpisodeOrder(String filmEpisodeOrder) {
        this.filmEpisodeOrder = filmEpisodeOrder;
    }

    public String getFilmEpisodeView() {
        return filmEpisodeView;
    }

    public void setFilmEpisodeView(String filmEpisodeView) {
        this.filmEpisodeView = filmEpisodeView;
    }
}
