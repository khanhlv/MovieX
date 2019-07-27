package com.moviex.dto.model;

public class FilmEpisodeServerDto {
    private String id;
    private String filmEpisodeId;
    private String serverId;
    private String episodePart;
    private String filmEpisodeServerHD;
    private String filmEpisodeServerSD;

    private FilmEpisodeDto filmEpisodeInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmEpisodeId() {
        return filmEpisodeId;
    }

    public void setFilmEpisodeId(String filmEpisodeId) {
        this.filmEpisodeId = filmEpisodeId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getEpisodePart() {
        return episodePart;
    }

    public void setEpisodePart(String episodePart) {
        this.episodePart = episodePart;
    }

    public String getFilmEpisodeServerHD() {
        return filmEpisodeServerHD;
    }

    public void setFilmEpisodeServerHD(String filmEpisodeServerHD) {
        this.filmEpisodeServerHD = filmEpisodeServerHD;
    }

    public String getFilmEpisodeServerSD() {
        return filmEpisodeServerSD;
    }

    public void setFilmEpisodeServerSD(String filmEpisodeServerSD) {
        this.filmEpisodeServerSD = filmEpisodeServerSD;
    }

    public FilmEpisodeDto getFilmEpisodeInfo() {
        return filmEpisodeInfo;
    }

    public void setFilmEpisodeInfo(FilmEpisodeDto filmEpisodeInfo) {
        this.filmEpisodeInfo = filmEpisodeInfo;
    }
}
