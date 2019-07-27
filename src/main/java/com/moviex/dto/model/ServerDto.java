package com.moviex.dto.model;

import java.util.List;

public class ServerDto {
    private String id;
    private String serverName;

    private List<FilmEpisodeServerDto> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<FilmEpisodeServerDto> getData() {
        return data;
    }

    public void setData(List<FilmEpisodeServerDto> data) {
        this.data = data;
    }
}
