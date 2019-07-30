package com.moviex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviex.model.Film;
import com.moviex.service.repository.FilmRepository;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAllWithPagination(Long page, Long limit){

        List<Film> filmList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page.intValue(), limit.intValue());

        filmRepository.findAllWithPagination(pageable).forEach(filmList::add);

        return filmList;
    }

    public List<Film> findAllIMDBWithPagination(Long page, Long limit){

        List<Film> filmList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page.intValue(), limit.intValue());

        filmRepository.findAllIMDBWithPagination(pageable).forEach(filmList::add);

        return filmList;
    }

    public List<Film> findByCategoryWithPagination(Long categoryId, Long page, Long limit){

        List<Film> filmList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page.intValue(), limit.intValue());

        filmRepository.findByCategoryWithPagination(pageable, categoryId).forEach(filmList::add);

        return filmList;
    }

    public Film findFilmByFilmId(Long filmId){
        return filmRepository.findFilmByFilmId(filmId);
    }

}
