package com.moviex.service;

import com.moviex.model.Film;
import com.moviex.service.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAll(){
        List<Film> filmList = new ArrayList<>();
        filmRepository.findAll().forEach(filmList::add);
        return filmList;
    }
}
