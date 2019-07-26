package com.moviex.service.repository;

import com.moviex.model.FilmEpisode;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FilmEpisodeRepository extends CrudRepository<FilmEpisode, Long> {
    Collection<FilmEpisode> findByFilmIdOrderByFilmEpisodeOrderAsc(Long filmId);
}