package com.moviex.service.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.moviex.model.FilmEpisodeServer;

public interface FilmEpisodeServerRepository extends CrudRepository<FilmEpisodeServer, Long> {
    Collection<FilmEpisodeServer> findByFilmEpisodeIdAndAndServerId(Long filmEpisodeId, Long serverId);
}