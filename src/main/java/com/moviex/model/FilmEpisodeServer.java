package com.moviex.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FILM_EPISODE_SERVER", schema = "dbo")
public class FilmEpisodeServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_EPISODE_SERVER_ID")
    private Long filmEpisodeServerId;

    @Column(name = "FILM_EPISODE_ID")
    private Long filmEpisodeId;

    @Column(name = "SERVER_ID")
    private Long serverId;

    @Column(name = "EPISODE_PART")
    private Long episodePart;

    @Column(name = "FILM_EPISODE_SERVER_HD")
    private String filmEpisodeServerHD;

    @Column(name = "FILM_EPISODE_SERVER_SD")
    private String filmEpisodeServerSD;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "CREATED_USER_ID")
    private Long createdUserId;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "UPDATED_USER_ID")
    private Long updatedUserId;

    @Column(name = "STATUS")
    private Long status;

    public Long getFilmEpisodeServerId() {
        return filmEpisodeServerId;
    }

    public void setFilmEpisodeServerId(Long filmEpisodeServerId) {
        this.filmEpisodeServerId = filmEpisodeServerId;
    }

    public Long getFilmEpisodeId() {
        return filmEpisodeId;
    }

    public void setFilmEpisodeId(Long filmEpisodeId) {
        this.filmEpisodeId = filmEpisodeId;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Long getEpisodePart() {
        return episodePart;
    }

    public void setEpisodePart(Long episodePart) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
