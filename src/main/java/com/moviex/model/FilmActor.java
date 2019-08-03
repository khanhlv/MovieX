package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "FILM_ACTOR", schema = "dbo")
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "FILM_ACTOR_ID")
    private Long filmActorId;

    @Column(name = "ACTOR_ID")
    private Long actorId;

    @Column(name = "FILM_ID")
    private Long filmId;

    @Column(name = "CHARACTER_NAME")
    private String characterName;

    public Long getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(Long filmActorId) {
        this.filmActorId = filmActorId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
