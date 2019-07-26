package com.moviex.controller;

import com.moviex.dto.model.FilmDto;
import com.moviex.dto.model.FilmEpisodeDto;
import com.moviex.dto.response.FilmEpisodeResponseDto;
import com.moviex.dto.response.FilmResponseDto;
import com.moviex.model.Film;
import com.moviex.model.FilmEpisode;
import com.moviex.service.FilmEpisodeService;
import com.moviex.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmEpisodeService filmEpisodeService;

    @GetMapping("/list")
    public FilmResponseDto list(
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmDto> listData = new ArrayList<>();
        FilmResponseDto responseDto = new FilmResponseDto();

        filmService.findAllWithPagination(page, limit).forEach(v -> toModel(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/listByCategory")
    public FilmResponseDto listByCategory(
            @RequestParam(name = "categoryId", defaultValue = "0", required = false) Long categoryId,
            @RequestParam(name = "page", defaultValue = "0", required = false) Long page,
            @RequestParam(name = "limit", defaultValue = "10", required = false) Long limit) {
        List<FilmDto> listData = new ArrayList<>();
        FilmResponseDto responseDto = new FilmResponseDto();

        filmService.findByCategoryWithPagination(categoryId, page, limit).forEach(v -> toModel(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/detail")
    public FilmResponseDto detail(
            @RequestParam(name = "filmId", defaultValue = "0", required = false) Long filmId) {
        List<FilmDto> listData = new ArrayList<>();
        FilmResponseDto responseDto = new FilmResponseDto();

        Film film  = filmService.findFilmByFilmId(filmId);

        if (film != null) {
            toModel(film, listData);
        }

        responseDto.setData(listData);

        return responseDto;
    }

    @GetMapping("/episode")
    public FilmEpisodeResponseDto episode(
            @RequestParam(name = "filmId", defaultValue = "0", required = false) Long filmId) {
        List<FilmEpisodeDto> listData = new ArrayList<>();
        FilmEpisodeResponseDto responseDto = new FilmEpisodeResponseDto();

        filmEpisodeService.findByFilmId(filmId).forEach(v -> toModelEpisode(v, listData));

        responseDto.setData(listData);

        return responseDto;
    }

    private void toModelEpisode(FilmEpisode film, List<FilmEpisodeDto> listData) {
        final FilmEpisodeDto filmDto = new FilmEpisodeDto();
        filmDto.setId(film.getFilmEpisodeId().toString());
        filmDto.setFilmId(film.getFilmId().toString());
        filmDto.setFilmEpisodeName(film.getFilmEpisodeName());
        filmDto.setFilmEpisodeOrder(film.getFilmEpisodeOrder().toString());
        filmDto.setFilmEpisodeView(film.getFilmEpisodeView().toString());
        listData.add(filmDto);
    }

    private void toModel(Film film, List<FilmDto> listData) {
        final FilmDto filmDto = new FilmDto();
        filmDto.setId(film.getFilmId().toString());
        filmDto.setFilmNameVN(film.getFilmNameVN());
        filmDto.setFilmNameEN(film.getFilmNameEN());
        listData.add(filmDto);
    }


}
