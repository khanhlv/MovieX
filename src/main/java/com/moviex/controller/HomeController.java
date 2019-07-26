package com.moviex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviex.dto.common.ResponseDto;

@RestController
public class HomeController {

    @GetMapping("/index")
    public ResponseDto home() {
        return new ResponseDto();
    }
}
