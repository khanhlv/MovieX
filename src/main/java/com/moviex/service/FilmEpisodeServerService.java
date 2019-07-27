package com.moviex.service;

import com.moviex.model.FilmEpisodeServer;
import com.moviex.service.repository.FilmEpisodeServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmEpisodeServerService {

    @Autowired
    private FilmEpisodeServerRepository filmEpisodeServerRepository;

    public FilmEpisodeServer findByServerIdAndEpisodeId(Long episodeId, Long serverId){
        return filmEpisodeServerRepository.findByFilmEpisodeIdAndAndServerId(episodeId, serverId);
    }
}
