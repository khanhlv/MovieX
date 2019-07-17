package com.moviex.controller;

import com.moviex.model.Film;
import com.moviex.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/index")
    public List<Film> home() {
        return filmService.getAll();
    }
}
