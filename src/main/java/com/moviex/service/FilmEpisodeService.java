package com.moviex.service;

import com.moviex.model.FilmEpisode;
import com.moviex.service.repository.FilmEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmEpisodeService {

    @Autowired
    private FilmEpisodeRepository filmEpisodeRepository;

    public List<FilmEpisode> findByFilmId(Long filmId){

        List<FilmEpisode> filmListEpisodes = new ArrayList<>();
        filmEpisodeRepository.findByFilmIdOrderByFilmEpisodeOrderAsc(filmId).forEach(filmListEpisodes::add);

        return filmListEpisodes;
    }
}
