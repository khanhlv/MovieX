package com.moviex.service.repository;

import com.moviex.model.FilmEpisodeServer;
import org.springframework.data.repository.CrudRepository;

public interface FilmEpisodeServerRepository extends CrudRepository<FilmEpisodeServer, Long> {
    FilmEpisodeServer findByFilmEpisodeIdAndAndServerId(Long filmEpisodeId, Long serverId);
}