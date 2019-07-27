package com.moviex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviex.model.FilmEpisodeServer;
import com.moviex.service.repository.FilmEpisodeServerRepository;

@Service
public class FilmEpisodeServerService {

    @Autowired
    private FilmEpisodeServerRepository filmEpisodeServerRepository;

    public List<FilmEpisodeServer> findByServerIdAndEpisodeId(Long episodeId, Long serverId){

        List<FilmEpisodeServer> filmListEpisodes = new ArrayList<>();
        filmEpisodeServerRepository.findByFilmEpisodeIdAndAndServerId(episodeId, serverId).forEach(filmListEpisodes::add);

        return filmListEpisodes;
    }
}
